package com.techm.transport.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="table_vehicle_type")
public class VehicleType{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer vId;
	
	@Column(name="vehicle_name")
	private String	vecTypeName;

	

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getVecTypeName() {
		return vecTypeName;
	}

	public void setVecTypeName(String vecTypeName) {
		this.vecTypeName = vecTypeName;
	}
}
