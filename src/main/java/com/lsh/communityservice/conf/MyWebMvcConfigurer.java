package com.lsh.communityservice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author lushao
 * @Description
 * @Date 2023/6/11 1:11
 * @Version 1.0
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration ir=registry.addInterceptor(new LoginInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/login","/js/**","/Assets/**","/layer/**","/css/**","/layui/**","/toPage/login","/system/captcha/generate");
    }
}