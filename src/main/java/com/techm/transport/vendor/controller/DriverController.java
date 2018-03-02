package com.techm.transport.vendor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.exception.DriException;
import com.techm.transport.vendor.service.DriverService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("1.0")
@Api(description="Driver operations", tags= {"Drivers"})
public class DriverController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private DriverService service;
	
	@ApiOperation(value = "${DriverController.getDriByName}", response = Driver.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	@GetMapping("dri/{id}")
	public ResponseEntity<Driver> getDriByName(@ApiParam(name = "id", value = "Id of driver", required = true) @PathVariable("id") Integer id){
		LOGGER.info("Getting driver details of id-" + id);
		
		Driver dri = service.getDribyId(id);
		
		if(dri== null)
		{
			throw new DriException("Driver not found with id: "+ id);
		}
		return new ResponseEntity<Driver>(dri, HttpStatus.OK);
	}
	
	@ApiOperation(value = "${DriverController.getAllDri}", response = Driver.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	
	@GetMapping("dris")
	public ResponseEntity<List<Driver>> getAllDri(){
		LOGGER.info("Getting alldriver details-");
		
		List<Driver> dris = service.getAllDrivers();
		return new ResponseEntity<List<Driver>>(dris, HttpStatus.OK);
	}
	
	@ApiOperation(value = "${DriverController.addDriver}", response = Driver.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	
	@PostMapping("dri")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver dri, UriComponentsBuilder builder){
		System.out.println("Adding driver details..." + dri);
		
		LOGGER.info("Adding driver details" + dri);
		
		Driver dbDri = service.addDriver(dri);
		
		if (dri == null) {
			
			LOGGER.info("inside flag" + dri);
		//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			
		//return	new ResponseEntity<Driver>("driver alredy exist", HttpStatus.CONFLICT);
			
			
			return	new ResponseEntity<Driver>(dbDri,HttpStatus.CONFLICT);
			//throw new DriException("Driver alredy exist"+ dri.getDriname());
		}
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/1.0/dri/{id}").buildAndExpand(dri.getId()).toUri());
		//headers.add("driverId", Integer.valueOf(dri.getId()).toString());
		
		LOGGER.info("dbDri" + dbDri);
		return new ResponseEntity<Driver>(dbDri,headers, HttpStatus.CREATED);
		
		
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
