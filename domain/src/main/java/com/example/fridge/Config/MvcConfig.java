package com.example.fridge.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/ui/")
                .addResourceLocations("classpath:/static");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
