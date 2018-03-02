package com.techm.transport.vendor.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.repository.DriRepository;
//import com.techm.repository.OrgRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Service
public class DriverService extends BaseService{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DriRepository driRepository;

	public List<Driver> getAllDrivers(){
		List<Driver> list = new ArrayList<Driver>();
		LOGGER.info("Getting driver's list-" + list);
		Iterator<Driver> itr = driRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized Driver addDriver(Driver dri) {
		Driver dbDri = driRepository.findByDriName(dri.getDriname()); 	
		LOGGER.info("Getting driver details-" + dbDri);
		/*if (dbDri!=null) {
			return false;
		} else {
			driRepository.save(dri);
			return true;
		}*/
		
		
		if(dbDri==null)
		{
			driRepository.save(dri);
		return dri;
		}
		
		return dri;
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
