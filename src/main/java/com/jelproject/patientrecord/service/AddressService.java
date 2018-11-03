package com.jelproject.patientrecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jelproject.patientrecord.dao.CityRepository;
import com.jelproject.patientrecord.dao.DistrictRepository;
import com.jelproject.patientrecord.dao.ProvinceRepository;
import com.jelproject.patientrecord.model.City;
import com.jelproject.patientrecord.model.District;
import com.jelproject.patientrecord.model.Province;

@Service
public class AddressService 
{
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<Province> findProvince(String provinceId)
	{
		return provinceRepository.findById(Long.parseLong(provinceId));
	}
	
	public List<Province> findAllProvince()
	{
		return provinceRepository.findAll();
	}
	
	public List<Object[]> findAllProvincesCitiesDistricts()
	{
		return provinceRepository.findAllProvincesCitiesDistricts();
	}
	
	public List<City> findCitiesByProvinceId(String provinceId)
	{
		return cityRepository.findByProvinceId(Long.parseLong(provinceId));
	}
	
	public List<District> findDistrictsByCityId(String cityId)
	{
		return districtRepository.findByCityId(Long.parseLong(cityId));
	}
}
