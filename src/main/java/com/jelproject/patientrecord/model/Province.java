package com.jelproject.patientrecord.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PROVINCE")
public class Province 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PROVINCE_ID")
	private long id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="DESCRIPTION")
	private String description;
	
//	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private Collection<City> cities;
	
	public Province()
	{
		
	}
	
	public Province(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<City> getCities() {
		return cities;
	}

	public void setCities(Collection<City> cities) {
		this.cities = cities;
	}
	
	

}
