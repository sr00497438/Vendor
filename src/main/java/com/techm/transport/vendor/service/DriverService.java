package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.repository.DriRepository;
//import com.techm.repository.OrgRepository;
@Service
public class DriverService extends BaseService{

	@Autowired
	private DriRepository driRepository;

	public List<Driver> getAllDrivers(){
		List<Driver> list = new ArrayList<Driver>();

		Iterator<Driver> itr = driRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized boolean addDriver(Driver dri) {
		Driver dbDri = driRepository.findByDriName(dri.getDriname()); 	
		if (dbDri!=null) {
			return false;
		} else {
			driRepository.save(dri);
			return true;
		}
	}
	
	public Driver getDribyName(String driName) {
		Driver dri = driRepository.findByDriName(driName);
		return dri;
	}
	public Driver getDribyId(Integer id) {
		Driver dri = driRepository.findById(id);
		return dri;
	}
	
	public void updateDriver(Driver dri) {
		driRepository.save(dri);
	}
	
	public void deleteDriver(Integer id) {
		driRepository.delete(getDribyId(id));
	}
	
}
