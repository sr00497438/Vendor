package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.entity.Vehicle;
import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.repository.DriRepository;
import com.techm.transport.vendor.repository.VecRepository;
import com.techm.transport.vendor.repository.VecTypeRepository;

import com.techm.transport.vendor.entity.Sample;

@Service
public class VehicleService extends BaseService{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VecRepository vecRepository;
	@Autowired
	private DriRepository driRepository;
	@Autowired
	private VecTypeRepository vecTypeRepository;
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
		Vehicle dbvec = vecRepository.findByVehicleRegNo(Vec.getVehicleRegNo()); 
		LOGGER.info("Getting Vehicle details" + dbvec);

		if (dbvec == null) {
			LOGGER.info("Getting Vehicle details-" + dbvec);
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


	public Sample getVecbyName(String regNo) {
		Vehicle vec = vecRepository.findByVehicleRegNo(regNo);

		//Sample sam = new Sample();

		String regNo1 = vec.getVehicleRegNo();

		String verificationStatus = vec.getVerificationStatus();



		Driver dri = driRepository.findById(vec.getDriverId());
		VehicleType vecType = vecTypeRepository.findByvId(vec.getVehicleTypeId());

		String driverName = dri.getDriname();
		String vehicleType = vecType.getVecTypeName();


		Sample sam = new Sample(regNo1, driverName, vehicleType, verificationStatus);

		/*	sam.setVehicleRegNo(regNo1);

		sam.setDriverName(driverName);*/

		//sam.setVehicleRegNo(vec.getVehicleRegNo());	
		//sam.setVerificationStatus(vec.getVerificationStatus());

		//sam.setVehicleRegNo(regNo);

		return sam;
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
