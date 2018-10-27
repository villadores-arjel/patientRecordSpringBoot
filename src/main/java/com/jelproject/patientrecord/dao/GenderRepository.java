package com.jelproject.patientrecord.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelproject.patientrecord.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>
{

}
