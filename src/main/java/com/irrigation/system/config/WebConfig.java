package com.irrigation.system.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/irrigation/{spring:[\\w-]+}")
            .setViewName("forward:/irrigation/index.html ");
        registry.addViewController("/irrigation/**")
            .setViewName("forward:/irrigation/");
        registry.addViewController("/irrigation/**{spring:?!(\\.js|\\.css)$}")
            .setViewName("forward:/irrigation/");
    }
}


