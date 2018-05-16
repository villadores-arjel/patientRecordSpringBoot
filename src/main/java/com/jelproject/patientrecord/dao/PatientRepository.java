package com.jelproject.patientrecord.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jelproject.patientrecord.model.Patient;

@Repository
@Transactional(readOnly=true)
public interface PatientRepository extends JpaRepository<Patient, Long> 
{
//	@Query(nativeQuery=true, value="SELECT * FROM Patient WHERE UPPER(LAST_NAME) like UPPER(:name) OR UPPER(FIRST_NAME) like UPPER(:name)")
	@Query("SELECT p FROM Patient p WHERE UPPER(p.firstName) like UPPER(:name) OR UPPER(p.lastName) like UPPER(:name)")
	public List<Patient> findByName(@Param("name") String name);
//	public List<Patient> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String firstName, String lastName);
	public List<Patient> findById(long patientId);
	public List<Patient> findByFirstName(String firstName);
	public List<Patient> findByLastName(String lastName);
}
