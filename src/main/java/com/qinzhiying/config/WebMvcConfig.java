package com.qinzhiying.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] swaggerExcludes = new String[]{"/swagger-ui.html", "/swagger-resources/**", "/webjars/**"};
//        registry.addInterceptor(new UserInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(swaggerExcludes);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
