package com.techm.controller;

import java.util.List;
import java.util.logging.FileHandler;

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
import com.techm.entity.Vehicle;
import com.techm.service.DriverService;
//import com.techm.service.OrganizationService;
//import com.techm.service.VehicleService;
import com.techm.service.VehicleService;
import com.techm.transport.exception.DriException;

@Controller
@RequestMapping("transport")
public class VehicleController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    FileHandler fh;  
    
    
    

	
	@Autowired
	private VehicleService service;
	
	/*@GetMapping("vec/{regNo}")
	public ResponseEntity<Vehicle> getVec(@PathVariable("regNo") String regNo){
		LOGGER.info("Getting Vehicle  details of id-" +tbl_vehicle_type_id );
		
		Vehicle Vec = service.gettbl_vehicle_type_idbyId(tbl_vehicle_type_id);
		
		if(Vec== null)
		{
			throw new DriException("Vehicle not found with id: "+ tbl_vehicle_type_id);
		}
		//return new ResponseEntity<Driver>(dri, HttpStatus.OK);
		
		return new ResponseEntity<Vehicle>(Vec, HttpStatus.OK);
	}*/
	
	@GetMapping("vecs")
	public ResponseEntity<List<Vehicle>> getAllVec(){
		LOGGER.info("Getting all Vehicle details-" );

		
		List<Vehicle> Vecs = service.getAllVehicles();
		return new ResponseEntity<List<Vehicle>>(Vecs, HttpStatus.OK);
	}
	
	@PostMapping("vec/{regNo}/{vId}")

	public ResponseEntity<String> addVehicle(@PathVariable("regNo") String regNo, @PathVariable("vId") int vId,UriComponentsBuilder builder){
		LOGGER.info("Adding Vehicle  details-" +regNo );
		
		boolean flag = service.addVehicle(regNo,vId);
		System.out.println(flag);
		if (!flag) {
			return	new ResponseEntity<String>("vehicle alredy exist", HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/Vec/{id}").buildAndExpand(Vec.getvehicleTypeId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
   @PutMapping("vec")
	public ResponseEntity<Vehicle> updateOrganization(@RequestBody Vehicle Vec){
		service.updateVehicle(Vec);
		return new ResponseEntity<Vehicle>(Vec, HttpStatus.OK);
	}
	
	/*@DeleteMapping("vec/{id}")
	public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer id){
		service.deleteVehicle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}*/

}
