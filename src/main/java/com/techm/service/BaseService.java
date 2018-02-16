package com.techm.service;

import java.util.Date;

import com.techm.entity.BaseEntity;

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
