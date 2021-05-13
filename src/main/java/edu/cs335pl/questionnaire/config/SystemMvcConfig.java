package edu.cs335pl.questionnaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SystemMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //够闲的话可以加上语言模块
    @Bean
    public LocaleResolver localeResolver(){ return new SystemLocalResolver();}

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        //!!!!!!!!!!!!!!!页面还没写 记得改！！！！！！！！！！！！！！！！！！！
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/",
                "/user/login","/css/*","/js/**","/img/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"
                );

    }
}
