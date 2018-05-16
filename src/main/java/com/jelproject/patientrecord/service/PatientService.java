package com.jelproject.patientrecord.service;

import java.util.List;

import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.model.PatientRecord;

public interface PatientService 
{
	public List<Patient> findByID(String patientId);
	public List<Patient> findByName(String name);
	public List<Patient> findAll();
	public Patient add(Patient patient);
	public Patient update(String patientId, Patient patient);
	public List<PatientRecord> findRecords(String patientId);
	public List<PatientRecord> findByRecordId(String patientId, String recordId);
	public PatientRecord addRecord(String patientId, PatientRecord record);
	public PatientRecord updateRecord(String patientId, String recordId, PatientRecord record);
} 
