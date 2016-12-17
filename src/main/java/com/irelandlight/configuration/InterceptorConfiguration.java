package com.irelandlight.configuration;

import com.irelandlight.interceptor.LoginRequiredInterceptor;
import com.irelandlight.interceptor.PassportInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by destiny on 2016/12/14.
 */
@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

    @Resource
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Resource
    private PassportInterceptor passportInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequiredInterceptor);
        super.addInterceptors(registry);
    }
}
