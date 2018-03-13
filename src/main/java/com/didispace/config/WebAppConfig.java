package com.didispace.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.didispace.interceptor.UserSecurityInterceptor;



public class WebAppConfig extends WebMvcConfigurerAdapter {
	/** 
     * 配置拦截器 
     * @author lance 
     * @param registry 
     */  
    @Override
	public void addInterceptors(InterceptorRegistry registry) {  
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/user/**");  
    }  
}
