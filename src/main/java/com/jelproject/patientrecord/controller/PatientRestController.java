package com.jelproject.patientrecord.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.model.PatientRecord;
import com.jelproject.patientrecord.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientRestController 
{
	private PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService patientService)
	{
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public ResponseEntity<?> getPatients(@RequestParam(value="name", required=false) String name)
	{
		List<Patient> patients = new ArrayList<>();
		if(name!=null)
		{
			patients = patientService.findByName(name);
		}
		else
		{
			patients = patientService.findAll();
		}
		
		if(patients!=null)
		{
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/patients/{patientId}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatientByID(@PathVariable("patientId") String patientId)
	{
		List<Patient> patients = patientService.findByID(patientId);
		if(patients!=null)
		{
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
		}
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/patients", method = RequestMethod.POST)
	public ResponseEntity<?> addPatient(@Valid @RequestBody Patient patient)
	{
		Patient response = patientService.add(patient);
		if(response!=null)
		{
			return new ResponseEntity<Patient>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Patient>(response, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/patients/{patientId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePatient(@PathVariable("patientId") String patientId, @Valid @RequestBody Patient patient)
	{
		Patient response = patientService.update(patientId, patient);
		if(response!=null)
		{
			return new ResponseEntity<Patient>(response, HttpStatus.OK);
		}
		return new ResponseEntity<Patient>(response, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/patients/{patientId}/records", method = RequestMethod.GET)
	public ResponseEntity<?> getPatientRecords(@PathVariable("patientId") String patientId)
	{
		List<PatientRecord> patientRecords = patientService.findRecords(patientId);
		if(patientRecords!=null)
		{
			return new ResponseEntity<List<PatientRecord>>(patientRecords, HttpStatus.OK);
		}
		return new ResponseEntity<List<PatientRecord>>(patientRecords, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/patients/{patientId}/records", method = RequestMethod.POST)
	public ResponseEntity<?> addPatientRecord(@PathVariable("patientId") String patientId, @Valid @RequestBody PatientRecord record)
	{
		PatientRecord patientRecord = patientService.addRecord(patientId, record);
		if(patientRecord!=null)
		{
			return new ResponseEntity<PatientRecord>(patientRecord, HttpStatus.OK);
		}
		return new ResponseEntity<PatientRecord>(patientRecord, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/patients/{patientId}/records/{recordId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewPatientRecord(@PathVariable("patientId") String patientId,
			@PathVariable("recordId") String recordId)
	{
		List<PatientRecord> patientRecords = patientService.findByRecordId(patientId, recordId);
		if(patientRecords!=null)
		{
			return new ResponseEntity<List<PatientRecord>>(patientRecords, HttpStatus.OK);
		}
		return new ResponseEntity<List<PatientRecord>>(patientRecords, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/patients/{patientId}/records/{recordId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePatientRecord(@PathVariable("patientId") String patientId,
			@PathVariable("recordId") String recordId, @Valid @RequestBody PatientRecord record)
	{
		PatientRecord patientRecord = patientService.updateRecord(patientId, recordId, record);
		if(patientRecord!=null)
		{
			return new ResponseEntity<PatientRecord>(patientRecord, HttpStatus.OK);
		}
		return new ResponseEntity<PatientRecord>(patientRecord, HttpStatus.NOT_FOUND);
	}
	

}
