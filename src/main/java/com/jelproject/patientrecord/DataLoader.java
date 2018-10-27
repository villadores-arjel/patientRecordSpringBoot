package com.jelproject.patientrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jelproject.patientrecord.dao.GenderRepository;
import com.jelproject.patientrecord.model.Gender;

@Component
public class DataLoader implements ApplicationRunner
{
	@Autowired
	private GenderRepository genderRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Gender male = new Gender();
		male.setCode("M");
		male.setDescription("Male");
		
		Gender female = new Gender();
		female.setCode("F");
		female.setDescription("Female");
		
		genderRepository.save(male);
		genderRepository.save(female);
		
	}
}


