package com.jelproject.patientrecord.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jelproject.patientrecord.model.City;
import com.jelproject.patientrecord.model.District;
import com.jelproject.patientrecord.model.Province;
import com.jelproject.patientrecord.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController 
{
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<?> getAddress()
	{
		List<Object[]> address = addressService.findAllProvincesCitiesDistricts();
		
		if(address!=null)
		{
			return new ResponseEntity<List<Object[]>>(address, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Object[]>>(address, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/provinces", method = RequestMethod.GET)
	public ResponseEntity<?> getProvinces(@RequestParam(value="provinceId", required=false) String provinceId)
	{
		List<Province> provinces = new ArrayList<>();
		if(provinceId!=null)
		{
			provinces = addressService.findProvince(provinceId);
		}
		else
		{
			provinces = addressService.findAllProvince();
		}
		
		if(provinces!=null)
		{
			return new ResponseEntity<List<Province>>(provinces, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Province>>(provinces, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/provinces/{provinceId}/cities", method = RequestMethod.GET)
	public ResponseEntity<?> getCitiesByProvinceId(@PathVariable("provinceId") String provinceId)
	{
		List<City> cities = addressService.findCitiesByProvinceId(provinceId);
		if(cities!=null)
		{
			return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<City>>(cities, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/provinces/{provinceId}/cities/{cityId}/districts", method = RequestMethod.GET)
	public ResponseEntity<?> getDistrictByCityId(@PathVariable("provinceId") String provinceId, @PathVariable("cityId") String cityId)
	{
		List<District> districts = addressService.findDistrictsByCityId(cityId);
		if(districts!=null)
		{
			return new ResponseEntity<List<District>>(districts, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<District>>(districts, HttpStatus.NOT_FOUND);
	}

}
