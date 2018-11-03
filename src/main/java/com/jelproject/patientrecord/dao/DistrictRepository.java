package com.jelproject.patientrecord.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelproject.patientrecord.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>
{
	List<District> findByCityId(long id);
}
