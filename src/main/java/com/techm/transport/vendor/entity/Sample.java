package com.techm.transport.vendor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import io.swagger.annotations.ApiModelProperty;



public class Sample{
	//public String	verificationStatus = "Pending";
	

	
	private String	vehicleRegNo;
	
	
	private String driverName;
	
	
	private String vehicleTypeName;
	
	
	private String	verificationStatus;
	
	
	
	/*public sample()
	{
		   
	}
	
	*/

	public Sample(String vehicleRegNo, String driverName, String vehicleTypeName, String verificationStatus) {
		//super();
		this.vehicleRegNo = vehicleRegNo;
		this.driverName = driverName;
		this.vehicleTypeName = vehicleTypeName;
		this.verificationStatus = verificationStatus;
	}



	public String getVehicleRegNo() {
		return vehicleRegNo;
	}



	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}



	public String getDriverName() {
		return driverName;
	}



	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	public String getVehicleTypeName() {
		return vehicleTypeName;
	}



	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}



	public String getVerificationStatus() {
		return verificationStatus;
	}



	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}


	

	
	
}
