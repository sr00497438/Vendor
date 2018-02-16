package com.techm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tbl_drivers")
public class Driver{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	//@ApiModelProperty(notes="this is db generated.....")
	private int id;
	
	@Column(name="driver_name")
	
	private String	driName;
	@Column(name="license_number")
	private String  license_number;
	@Column(name="mobile_no")
	private String  mobile_number;
	@Column(name="address")
	private String  address;
	
	
	
	public Driver()
	{
		  
	}
	
	
	

	@ApiModelProperty(hidden  = true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	
	@ApiModelProperty(required=true)
	public String getDriname() {
		return driName;
	}

	public void setDriname(String driName) {
		this.driName = driName;
	}
	
	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	@ApiModelProperty(required  = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
