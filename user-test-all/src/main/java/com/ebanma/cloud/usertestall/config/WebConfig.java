package com.ebanma.cloud.usertestall.config;

import com.ebanma.cloud.usertestall.interceptor.RateLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author 于秦涛
 * @version $ Id: WebConfig, v 0.1 2023/03/22 15:06 98077 Exp $
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private RateLimitInterceptor rateLimitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/api/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                //前面要有file：，后面要有/
                //访问的时候直接访问localhost：8080/uploads/xxx（文件名全名）
                .addResourceLocations("file:D:/Tools/idea-workspace/alibaba-faw-source/uploads/");
    }
}

