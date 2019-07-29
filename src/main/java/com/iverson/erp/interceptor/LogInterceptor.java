package com.iverson.erp.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iverson.erp.pojo.LogInfo;
import com.iverson.erp.service.LogService;
import com.iverson.erp.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    private LogService logService;

    private static final String LOG_SEND_TIME = "_send_time_";
    private static final String LOG_INFO = "_log_info_";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LogInfo logInfo = new LogInfo();
        String param = JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
        logInfo.setClientIp(LogUtil.getClientIp(request));
        logInfo.setUri(request.getRequestURI());
        logInfo.setType(LogUtil.getRequestType(request));
        logInfo.setMethod(request.getMethod());
        logInfo.setParam(param);
        logInfo.setToken(request.getRequestedSessionId());
        request.setAttribute(LOG_SEND_TIME,System.currentTimeMillis());
        request.setAttribute(LOG_INFO,logInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LogInfo logInfo = (LogInfo) request.getAttribute(LOG_INFO);
        long currentTime = System.currentTimeMillis();
        long time = Long.parseLong(request.getAttribute(LOG_SEND_TIME).toString());
        logInfo.setHttpStatusCode(String.valueOf(response.getStatus()));
        logInfo.setTimeConsuming(Integer.valueOf(String.valueOf(currentTime - time)));
        logInfo.setReturnTime(String.valueOf(currentTime));
        logInfo.setReturnData(JSON.toJSONString(request.getAttribute(LogUtil.LOG_RETURN),SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue));
        logService.save(logInfo);
        log.info("写入成功");
    }
}
