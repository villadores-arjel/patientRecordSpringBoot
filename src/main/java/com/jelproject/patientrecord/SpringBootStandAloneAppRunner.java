package com.jelproject.patientrecord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


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
	
	@Bean
	public MessageSource messageSource() 
	{
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:errorMessages");
	    messageSource.setCacheSeconds(10); //reload messages every 10 seconds
	    return messageSource;
	}

}
