package com.techm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GenerationVerification;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vehicle_verification")
public class VehicleVerification{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="name")
	private String	vecVerificationName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getvecVerificationname() {
		return vecVerificationName;
	}

	public void setvecVerificationname(String vecVerificationName) {
		this.vecVerificationName = vecVerificationName;
	}
	
}
