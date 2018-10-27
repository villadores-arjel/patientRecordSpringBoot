package com.jelproject.patientrecord.model.dto;

import com.jelproject.patientrecord.model.Gender;
import com.jelproject.patientrecord.model.Patient;

public class PatientDTO 
{
	private Gender gender;
	private Patient patient;
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
