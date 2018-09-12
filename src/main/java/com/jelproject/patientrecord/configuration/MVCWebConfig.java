package com.jelproject.patientrecord.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MVCWebConfig implements WebMvcConfigurer
{
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //to do: add interceptor classes
		
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
	    localeInterceptor.setParamName("lang");
	    
	    
	    registry.addInterceptor(localeInterceptor).addPathPatterns("/home");
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	

}
