package com.techm.transport.vendor.repository;

import org.springframework.data.repository.CrudRepository;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.entity.VehicleVerification;

public interface VecVerificationRepository extends CrudRepository<VehicleVerification, Long>{
	VehicleVerification findByVecVerificationName(String name);
	VehicleVerification findById(Integer id);
}
