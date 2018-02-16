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
import com.techm.entity.VehicleType;
import com.techm.service.DriverService;
//import com.techm.service.OrganizationService;
//import com.techm.service.VehicleService;
import com.techm.service.VehicleTypeService;

@Controller
@RequestMapping("transport")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService service;
	
	@GetMapping("vecType/{id}")
	public ResponseEntity<VehicleType> getVecTypeByName(@PathVariable("id") Integer id){
		VehicleType vecType = service.getVecTypebyId(id);
		return new ResponseEntity<VehicleType>(vecType, HttpStatus.OK);
	}
	
	@GetMapping("vecTypes")
	public ResponseEntity<List<VehicleType>> getAllVectype(){
		List<VehicleType> vecTypes = service.getAllVehicleTypes();
		return new ResponseEntity<List<VehicleType>>(vecTypes, HttpStatus.OK);
	}
	
	@PostMapping("vecType/{id}/{vecTypeName}")
	public ResponseEntity<Void> addVehicleType(@PathVariable("vecTypeName") String vecType, UriComponentsBuilder builder){
		boolean flag = service.addVehicleType(vecType);
		if (!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/vecType/{id}").buildAndExpand(vecType.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/*@PutMapping("vecType")
	public ResponseEntity<VehicleType> updateOrganization(@RequestBody VehicleType vecType){
		service.updateVehicleType(vecType);
		return new ResponseEntity<VehicleType>(vecType, HttpStatus.OK);
	}
	
	@DeleteMapping("vecType/{id}")
	public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer id){
		service.deleteVehicleType(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/

}
