package com.techm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.techm.entity.Driver;
//import com.techm.entity.Organization;
import com.techm.service.DriverService;
import com.techm.transport.exception.DriException;
//import com.techm.service.OrganizationService;

@Controller
@RequestMapping("transport")
public class DriverController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private DriverService service;
	
	@GetMapping("dri/{id}")
	public ResponseEntity<Driver> getDriByName(@PathVariable("id") Integer id){
		LOGGER.info("Getting driver details of id-" + id);
		
		Driver dri = service.getDribyId(id);
		
		if(dri== null)
		{
			throw new DriException("Driver not found with id: "+ id);
		}
		return new ResponseEntity<Driver>(dri, HttpStatus.OK);
	}
	
	@GetMapping("dris")
	public ResponseEntity<List<Driver>> getAllDri(){
		LOGGER.info("Getting alldriver details-");
		
		List<Driver> dris = service.getAllDrivers();
		return new ResponseEntity<List<Driver>>(dris, HttpStatus.OK);
	}
	
	@PostMapping("dri")
	public ResponseEntity<String> addDriver(@RequestBody Driver dri, UriComponentsBuilder builder){
		LOGGER.info("Adding driver details" + dri);
		
		boolean flag = service.addDriver(dri);
		if (!flag) {
		//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			
		return	new ResponseEntity<String>("driver alredy exist", HttpStatus.CONFLICT);
			//throw new DriException("Driver alredy exist"+ dri.getDriname());
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/dri/{id}").buildAndExpand(dri.getId()).toUri());
		//headers.add("driverId", Integer.valueOf(dri.getId()).toString());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	/*@PutMapping("dri")
	public ResponseEntity<Driver> updateOrganization(@RequestBody Driver dri){
		service.updateDriver(dri);
		return new ResponseEntity<Driver>(dri, HttpStatus.OK);
	}
	
	@DeleteMapping("dri/{id}")
	public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer id){
		service.deleteDriver(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/

}
