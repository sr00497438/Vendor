package com.techm.transport.vendor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techm.transport.vendor.entity.VehicleType;

@Repository
public interface VecTypeRepository extends CrudRepository<VehicleType, Long>{
	VehicleType findByVecTypeName(String name);
	VehicleType findByvId(Integer id);
}
