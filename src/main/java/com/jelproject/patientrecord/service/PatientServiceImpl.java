package com.jelproject.patientrecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jelproject.patientrecord.dao.PatientRecordRepository;
import com.jelproject.patientrecord.dao.PatientRepository;
import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.model.PatientRecord;

@Service("patientService")
public class PatientServiceImpl implements PatientService 
{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	@Override
	public List<Patient> findByID(String patientId)
	{
		List<Patient> patient = patientRepository.findById(Long.parseLong(patientId));
		if(patient!=null)
		{
			return patient;
		}
		return null; 
	}
	
	@Override
	public List<Patient> findByName(String name)
	{
		List<Patient> patients = patientRepository.findByName("%"+name+"%");
		if(patients!=null)
		{
			return patients;
		}
		return null;  
	}
	
	@Override
	public List<Patient> findAll()
	{
		List<Patient> patients = patientRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		if(patients!=null)
		{
			return patients;
		}
		return null;
	}
	
	

	@Override
	@Transactional
	public Patient add(Patient patient) {
		Patient response = null;
		try
		{
			patientRepository.save(patient);
			response = patientRepository.findById(patient.getId()).get(0);
		}
		catch(Exception err)
		{
			response = null;
		}
		return response;
	}

	@Override
	@Transactional
	public Patient update(String patientId, Patient patient) {
		Patient response = null;
		if(patientRepository.existsById(Long.parseLong(patientId)))
		{
			try
			{
				patient.setId(Long.parseLong(patientId));
				patientRepository.save(patient);
				response = patientRepository.findById(patient.getId()).get(0);
			}
			catch(Exception err)
			{
				response = null;
			}
		}
		return response;	
	}
	
	@Override
	public List<PatientRecord> findRecords(String patientId)
	{
		if(patientRepository.existsById(Long.parseLong(patientId)))
		{
			List<PatientRecord> records = patientRecordRepository.findByPatientId(Long.parseLong(patientId), new Sort(Sort.Direction.ASC, "id"));
			if(records!=null)
			{
				return records;
			}
			return null;
		}
		return null;
	}

	@Override
	public PatientRecord addRecord(String patientId, PatientRecord record) {
		if(patientRepository.existsById(Long.parseLong(patientId)))
		{
			Patient patient = patientRepository.findById(Long.parseLong(patientId)).get(0);
			try
			{
				record.setPatient(patient);
				patientRecordRepository.save(record);
				return patientRecordRepository.findById(record.getId()).get(0);
				
			}
			catch(Exception err)
			{
				return null;
			}
		}
		return null;
	}
	
	@Override
	public List<PatientRecord> findByRecordId(String patientId, String recordId)
	{
		if(patientRecordRepository.existsById(Long.parseLong(recordId)))
		{
			List<PatientRecord> record = patientRecordRepository.findById(Long.parseLong(recordId));
			if(record!=null && record.get(0).getPatient().getId()==Long.parseLong(patientId))
			{
				return record;
			}
			return null;
		}
		return null;
	}

	@Override
	public PatientRecord updateRecord(String patientId, String recordId, PatientRecord record) {
		if(patientRecordRepository.existsById(Long.parseLong(recordId)))
		{
			List<PatientRecord> rec = patientRecordRepository.findById(Long.parseLong(recordId));
			if(rec!=null && rec.get(0).getPatient().getId()==Long.parseLong(patientId))
			{
				try
				{
					record.setPatient(rec.get(0).getPatient());
					record.setId(Long.parseLong(recordId));
					patientRecordRepository.save(record);
					return patientRecordRepository.findById(record.getId()).get(0);
					
				}
				catch(Exception err)
				{
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public Page<Patient> findAllPaginate(Pageable pageable) 
	{
		Page<Patient> patients = patientRepository.findAll(pageable);
		if(patients!=null)
		{
			return patients;
		}
		return null;
	} 

}
