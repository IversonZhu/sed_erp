package com.iverson.erp.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 登录拦截器
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        start = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("Interceptor cost= " + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
