package com.iverson.erp.config;

import com.iverson.erp.interceptor.ApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: 接口的拦截配置
 *
 * @author Iverson
 * @version 1.00
 * @date 2019/7/15
 */
@Configuration
public class ApiInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private ApiInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/api/**");
    }
}
