package com.jelproject.patientrecord.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PATIENT_RECORD")
public class PatientRecord 
{
	
	@Id
//	@SequenceGenerator(name="recordSeqGen", sequenceName="PATIENT_RECORD_ID_SEQ", allocationSize = 1)
//	@GeneratedValue(generator="recordSeqGen", strategy=GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RECORD_ID")
	private long id;
	
	@Column(name="RECORD_TYPE")
	@NotNull
	@Min(1)
	@Max(999)
	private long type;
	
	@Column(name="RECORD_DESCRIPTION")
	@NotNull
	@Size(min=1, max=100)
	private String description;
	
//	@JsonIgnore
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID", nullable = false)
	private Patient patient;
	
	public PatientRecord()
	{
		
	}
	
	public PatientRecord(long type, String description, Patient patient)
	{
		this.type = type;
		this.description = description;
		this.patient = patient;
	}
	
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public long getType() 
	{
		return type;
	}
	public void setType(long type) 
	{
		this.type = type;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public Patient getPatient() 
	{
		return patient;
	}
	public void setPatient(Patient patient) 
	{
		this.patient = patient;
	}
	

}
