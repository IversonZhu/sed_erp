package com.iverson.erp.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.iverson.erp.util.RedisUtil;
import com.iverson.erp.vo.ResultVO;
import com.iverson.erp.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description: 登录拦截器
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String tokenNo = request.getHeader("token");
        UserVO userVO = (UserVO) redisUtil.get(tokenNo);
        if(userVO != null){
            return true;
        }
        response.setContentType("application/json; charset=utf-8");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(101);
        resultVO.setMsg("token失效");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.append(JSONObject.toJSON(resultVO).toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
