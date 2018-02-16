package com.techm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.techm.entity.Driver;

public interface DriRepository extends CrudRepository<Driver, Long>{
	Driver findByDriName(String name);
	Driver findById(Integer id);
}
