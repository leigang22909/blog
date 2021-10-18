package com.lrm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lenovo
 * @title: WebConfig
 * @projectName blog
 * @description: TODO
 * @date 2021/10/821:17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterception())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin","/admin/login");

    }
}
