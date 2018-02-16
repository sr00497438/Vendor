package com.techm.controller;

import java.util.List;

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
import com.techm.entity.VehicleVerification;
import com.techm.service.DriverService;
//import com.techm.service.OrganizationService;
//import com.techm.service.VehicleService;
import com.techm.service.VehicleVerificationService;

@RequestMapping("transport")
public class VehicleVerificationController {
	
	@Autowired
	private VehicleVerificationService service;
	
	@GetMapping("vecVerification/{id}")
	public ResponseEntity<VehicleVerification> getVecVerificationByName(@PathVariable("id") Integer id){
		VehicleVerification vecVerification = service.getVecVerificationbyId(id);
		return new ResponseEntity<VehicleVerification>(vecVerification, HttpStatus.OK);
	}
	
	@GetMapping("vecVerifications")
	public ResponseEntity<List<VehicleVerification>> getAllVecVerification(){
		List<VehicleVerification> vecVerifications = service.getAllVehicleVerifications();
		return new ResponseEntity<List<VehicleVerification>>(vecVerifications, HttpStatus.OK);
	}
	
	@PostMapping("vecVerification")
	public ResponseEntity<Void> addVehicleVerification(@RequestBody VehicleVerification vecVerification, UriComponentsBuilder builder){
		boolean flag = service.addVehicleVerification(vecVerification);
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/vecVerification/{id}").buildAndExpand(vecVerification.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/*@PutMapping("vecVerification")
	public ResponseEntity<VehicleVerification> updateOrganization(@RequestBody VehicleVerification vecVerification){
		service.updateVehicleVerification(vecVerification);
		return new ResponseEntity<VehicleVerification>(vecVerification, HttpStatus.OK);
	}
	
	@DeleteMapping("vecVerification/{id}")
	public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer id){
		service.deleteVehicleVerification(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/

}
