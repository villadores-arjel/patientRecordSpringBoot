package com.jelproject.patientrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jelproject.patientrecord.dao.CityRepository;
import com.jelproject.patientrecord.dao.DistrictRepository;
import com.jelproject.patientrecord.dao.GenderRepository;
import com.jelproject.patientrecord.dao.ProvinceRepository;
import com.jelproject.patientrecord.model.City;
import com.jelproject.patientrecord.model.District;
import com.jelproject.patientrecord.model.Gender;
import com.jelproject.patientrecord.model.Province;

@Component
public class DataLoader implements ApplicationRunner
{
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private DistrictRepository districtRepository;
	
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
		
		Province province1 = new Province("AAA", "Metro Manila");
		Province province2 = new Province("BBB", "Batangas");
		Province province3 = new Province("CCC", "Ilocos");
		
		City city1 = new City("AAA1", "Quezon City");
		City city2 = new City("AAA2", "Manila");
		City city3 = new City("BBB1", "Lipa");
		City city4 = new City("BBB2", "Nasugbu");
		City city5 = new City("CCC1", "Vigan");
		
		District district1 = new District("AAA1A", "District 1");
		District district2 = new District("AAA1B", "District 2");
		District district3 = new District("AAA2A", "District 1");
		District district4 = new District("BBB1A", "District 1");
		District district5 = new District("BBB2A", "District 1");

		
		city1.setProvince(province1);
		city2.setProvince(province1);
		city3.setProvince(province2);
		city4.setProvince(province2);
		city5.setProvince(province3);
		
		district1.setCity(city1);
		district2.setCity(city1);
		district3.setCity(city2);
		district4.setCity(city3);
		district5.setCity(city4);
		
		provinceRepository.save(province1);
		provinceRepository.save(province2);
		provinceRepository.save(province3);
		
		cityRepository.save(city1);
		cityRepository.save(city2);
		cityRepository.save(city3);
		cityRepository.save(city4);
		cityRepository.save(city5);
		
		districtRepository.save(district1);
		districtRepository.save(district2);
		districtRepository.save(district3);
		districtRepository.save(district4);
		districtRepository.save(district5);
	}
}


