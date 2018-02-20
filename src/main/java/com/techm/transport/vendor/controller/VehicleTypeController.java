package com.techm.transport.vendor.controller;

import java.util.List;

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

import com.techm.transport.vendor.entity.Vehicle;
import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.service.VehicleTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("transport/1.0")
@Api(description="VehicleType operations", tags= {"Vehicle Types"})
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService service;
	
	
	@ApiOperation(value = "${VehicleTypeController.getVecTypeByName}", response = Vehicle.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	
	@GetMapping("vecType/{id}")
	public ResponseEntity<VehicleType> getVecTypeByName(@ApiParam(name = "id", value = "Id of Vehicle Type", required = true) @PathVariable("id") Integer id){
		VehicleType vecType = service.getVecTypebyId(id);
		return new ResponseEntity<VehicleType>(vecType, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "${VehicleTypeController.getAllVectype}", response = Vehicle.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	
	@GetMapping("vecTypes")
	public ResponseEntity<List<VehicleType>> getAllVectype(){
		List<VehicleType> vecTypes = service.getAllVehicleTypes();
		return new ResponseEntity<List<VehicleType>>(vecTypes, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "${VehicleTypeController.addVehicleType}", response = Vehicle.class) 
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully get resource of given id"),
			@ApiResponse(code = 401, message = "Not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Not found resource you were trying to get."),
			@ApiResponse(code = 500, message = "Internal server error")
							}
					)
	
	@PostMapping("vecType")
	public ResponseEntity<Void> addVehicleType(@RequestBody VehicleType vecType, UriComponentsBuilder builder){
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
