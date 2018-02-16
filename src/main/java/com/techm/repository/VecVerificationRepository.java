package com.techm.repository;

import org.springframework.data.repository.CrudRepository;

import com.techm.entity.Driver;
import com.techm.entity.VehicleVerification;

public interface VecVerificationRepository extends CrudRepository<VehicleVerification, Long>{
	VehicleVerification findByVecVerificationName(String name);
	VehicleVerification findById(Integer id);
}
