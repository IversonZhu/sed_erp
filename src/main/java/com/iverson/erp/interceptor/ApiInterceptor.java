package com.iverson.erp.interceptor;

import com.iverson.erp.pojo.Machine;
import com.iverson.erp.pojo.Shop;
import com.iverson.erp.service.MachineService;
import com.iverson.erp.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 接口拦截器
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */

@Component
@Slf4j
public class ApiInterceptor implements HandlerInterceptor {

    @Autowired
    private MachineService machineService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String tokenNo = request.getHeader("token");
        log.info("token={}", tokenNo);
        Machine machine = machineService.getMachineByToken(tokenNo);
        if(machine != null) {
            log.info("【api拦截器验证】 result = {}" ,"success");
            return true;
        }
        response.sendRedirect("noToken");//应该返回一个结果出去
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
