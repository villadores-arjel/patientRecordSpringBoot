package com.jelproject.patientrecord.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jelproject.patientrecord.model.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long>
{
	List<Province> findById(long id);
	
	@Query("SELECT p, c, d "
			+ "FROM Province p LEFT JOIN p.cities c LEFT JOIN c.districts d")
	List<Object[]> findAllProvincesCitiesDistricts();

}
