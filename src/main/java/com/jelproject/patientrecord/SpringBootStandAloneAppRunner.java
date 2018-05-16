package com.jelproject.patientrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.service.PatientService;


@SpringBootApplication(scanBasePackages={"com.jelproject.patientrecord"})
public class SpringBootStandAloneAppRunner implements CommandLineRunner
{
	private PatientService patientService;
	
	@Autowired
	public SpringBootStandAloneAppRunner(PatientService patientService)
	{
		this.patientService = patientService;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootStandAloneAppRunner.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception 
	{

	}

}
