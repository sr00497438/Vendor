package com.techm.transport.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="table_vehicle_type")
public class VehicleType{
	
	public VehicleType()
	{
	}
	
	
	
	public VehicleType(Integer vId, String vecTypeName) {
		super();
		this.vId = vId;
		this.vecTypeName = vecTypeName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer vId;
	
	@Column(name="vehicle_name")
	private String	vecTypeName;

	
	@ApiModelProperty(hidden  = true)
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
