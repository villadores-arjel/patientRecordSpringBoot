package com.jelproject.patientrecord.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.model.PatientRecord;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long>
{
	public List<PatientRecord> findByPatientId(long patientId, Sort sort);
	public List<PatientRecord> findById(long recordId);
}
