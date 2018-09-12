package com.jelproject.patientrecord;

import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;


@SpringBootApplication(scanBasePackages={"com.jelproject.patientrecord"})
public class SpringBootStandAloneAppRunner implements CommandLineRunner
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootStandAloneAppRunner.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception 
	{

	}
	
//	@Bean
//  public ViewResolver viewResolver() {
//      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//      viewResolver.setViewClass(JstlView.class);
//      viewResolver.setPrefix("/WEB-INF/views/");
//      viewResolver.setSuffix(".jsp");
//
//      return viewResolver;
//  }
	
	@Bean
	public MessageSource messageSource() 
	{
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("classpath:errorMessages", "classpath:labels");
	    messageSource.setCacheSeconds(10); //reload messages every 10 seconds
	    return messageSource;
	}
	
	@Bean
    public LocaleResolver localeResolver()  {
       CookieLocaleResolver resolver= new CookieLocaleResolver();
//       resolver.setDefaultLocale(Locale.ENGLISH);
//       resolver.setCookieDomain("myAppLocaleCookie");
       // 60 minutes
//       resolver.setCookieMaxAge(60*60);
       return resolver;
    }

}
