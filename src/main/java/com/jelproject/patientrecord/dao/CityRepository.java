package com.jelproject.patientrecord.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelproject.patientrecord.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>
{
	List<City> findByProvinceId(long id);
}
