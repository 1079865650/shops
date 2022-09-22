package com.hs.shop.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 * @author :王文松
 * @date : 2022/9/21 19:20
 */
@Configuration
public class ReturnIndex implements WebMvcConfigurer {
    //templates中的默认路径由index.html改为 redirect:toMainPage
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("redirect:toMainPage");
//    }
}
