package com.techm.transport.vendor.service;

import java.util.Date;

import com.techm.transport.vendor.entity.BaseEntity;

public abstract class BaseService implements IBaseService{
	
	BaseEntity getEntitybyCreatedAt(Date createdAt) {
		BaseEntity entity=null;
		
		return entity;
	}
	BaseEntity getEntitybyCreatedBy(String createdBy) {
		BaseEntity entity=null;
		
		return entity;
	}
}
