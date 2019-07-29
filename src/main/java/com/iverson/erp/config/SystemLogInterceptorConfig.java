package com.iverson.erp.config;

import com.iverson.erp.interceptor.SystemLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * 系统拦截器拦截配置类(拦截所有)
 * @author Iverson
 * @version 1.00
 * @date 2019/7/29
 */
@Configuration
public class SystemLogInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SystemLogInterceptor systemLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(systemLogInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**");
    }
}
