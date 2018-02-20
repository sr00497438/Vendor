package com.techm.transport.vendor.repository;

import org.springframework.data.repository.CrudRepository;

import com.techm.transport.vendor.entity.Driver;

public interface DriRepository extends CrudRepository<Driver, Long>{
	Driver findByDriName(String name);
	Driver findById(int id);
}
