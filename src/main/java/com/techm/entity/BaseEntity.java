package com.techm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(name = "created_at")  
	private Date createdAt;  

	@Size(max = 20)  
	@Column(name = "created_by", length = 20)  
	private String createdBy;  

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(name = "updated_at")  
	private Date updatedAt;  

	@Size(max = 20)  
	@Column(name = "updated_by", length = 20)  
	private String updatedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
