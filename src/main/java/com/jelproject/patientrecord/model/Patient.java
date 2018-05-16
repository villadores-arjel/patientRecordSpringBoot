package com.jelproject.patientrecord.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PATIENT")
public class Patient 
{
	@Id
	@SequenceGenerator(name="patientSeqGen", sequenceName="PATIENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator="patientSeqGen", strategy=GenerationType.SEQUENCE)
	@Column(name="PATIENT_ID")
	private long id;
	
	@Column(name="FIRST_NAME")
	@NotNull
	@Size(min=1, max=35)
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotNull
	@Size(min=1, max=35)
	private String lastName;
	
	@Column(name="MIDDLE_NAME")
	@Size(max=35)
	private String midName;
	
	@Column(name="BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
//	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//	private Set<PatientRecord> record = new HashSet<>();
	
	public Patient()
	{
		
	}
	
	public Patient(String firstName, String midName, String lastName, Date bday)
	{
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.birthDate = bday;
	}
	
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getMidName() 
	{
		return midName;
	}
	public void setMidName(String midName) 
	{
		this.midName = midName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
//	public Set<PatientRecord> getRecord() {
//		return record;
//	}
//	public void setRecord(Set<PatientRecord> record) {
//		this.record = record;
//	}
	
}