package com.aaa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfing implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
         registry.addResourceHandler("/static/**","/templates/**","/img/**")
                 .addResourceLocations("classpath:/static/","file:/D:/MyImage/");
         WebMvcConfigurer.super.addResourceHandlers(registry);

         /*registry.addResourceHandler("/img/**").addResourceLocations("file:D/MyImage/");*/
    }


}
