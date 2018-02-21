package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.Vehicle;
import com.techm.transport.vendor.repository.VecRepository;

@Service
public class VehicleService extends BaseService{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VecRepository vecRepository;
	
//	@Autowired
//	private DriRepository driRepository;

	public List<Vehicle> getAllVehicles(){
		List<Vehicle> list = new ArrayList<Vehicle>();
		LOGGER.info("Getting vehicle's list-" + list);
		Iterator<Vehicle> itr = vecRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized Vehicle addVehicle(Vehicle Vec) {
		//long id = Vec.gettbl_vehicle_type_id();
		//System.out.println("------------"+id);
		//Vehicle dbvec = vecRepository.findByVehicleTypeId(id); 
		System.out.println("------------");
		Vehicle dbvec = vecRepository.findByVehicleTypeId(Vec.getVehicleTypeId()); 
		LOGGER.info("Getting Vehicle details-" + dbvec);
		System.out.println("------------"+dbvec);
		/*if (dbvec!=null) {
			return false;
		} else {
			vecRepository.save(Vec);
			return true;
		}*/
		
		if (dbvec == null) {
			
			LOGGER.info("Getting Vehicle default value-" + Vec.getVerificationStatus());  
			vecRepository.save(Vec);
			return Vec;
		} 
		else {
			return Vec;		
			}
		
	}
	public synchronized boolean addVehicle(String regNo,int vId, int vtId) {
		Vehicle dbvec = vecRepository.findByVehicleRegNo(regNo); 
		System.out.println("------------"+dbvec);
		if (dbvec!=null) {
			return false;
		} else {
			
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleRegNo(regNo);			
		
			vehicle.setDriverId(vId);
			vehicle.setVehicleTypeId(vtId);
				
			vecRepository.save(vehicle);
			return true;
		}
	}
	
	
	public Vehicle getVecbyName(String regNo) {
		Vehicle vec = vecRepository.findByVehicleRegNo(regNo);
		return vec;
	}
	
	//public synchronized boolean addVehicle(int tbl_vehicle_type_id) {
	//	if (gettbl_vehicle_type_idbyId(tbl_vehicle_type_id)!=null) {
		//	return false;
		//} //else {
		//	vec.add(new Vehicle());
			//return true;
		//return true;
		//}
	//}
	
	
	/*public Vehicle gettbl_vehicle_type_idbyId(int tbl_vehicle_type_id) {
		Vehicle vec = vecRepository.findBytbl_vehicle_type_id(tbl_vehicle_type_id);
		return vec;
	}
	public Vehicle gettbl_driver_idbyId(Integer tbl_driver_id) {
		Vehicle vec = vecRepository.findBytbl_driver_id(tbl_driver_id);
		return vec;
	}*/
	
	public void updateVehicle(String regNo, String verificationStatus) {
		
		Vehicle vec=vecRepository.findByVehicleRegNo(regNo);
		
		vec.setVerificationStatus(verificationStatus);
		vec.setVehicleRegNo(regNo);
		vecRepository.save(vec);
	}
	
	public void deleteVehicle(Integer id) {
		vecRepository.delete(gettbl_vehicle_type_idbyId(id));
	}

	public Vehicle gettbl_vehicle_type_id(Integer tbl_driver_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vehicle gettbl_vehicle_type_idbyId(Integer tbl_vehicle_type_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	