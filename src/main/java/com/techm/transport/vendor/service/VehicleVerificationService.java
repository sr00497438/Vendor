package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.VehicleVerification;
import com.techm.transport.vendor.repository.VecVerificationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Service
public class VehicleVerificationService extends BaseService{

	@Autowired
	private VecVerificationRepository vecVerificationRepository;

	public List<VehicleVerification> getAllVehicleVerifications(){
		List<VehicleVerification> list = new ArrayList<VehicleVerification>();

		Iterator<VehicleVerification> itr = vecVerificationRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized boolean addVehicleVerification(VehicleVerification vecVerification) {
		VehicleVerification dbVecVerification = vecVerificationRepository.findByVecVerificationName(vecVerification.getvecVerificationname()); 	
		if (dbVecVerification!=null) {
			return false;
		} else {
			vecVerificationRepository.save(vecVerification);
			return true;
		}
	}
	
	public VehicleVerification getVecVerificationbyName(String vecVerificationName) {
		VehicleVerification vecVerification = vecVerificationRepository.findByVecVerificationName(vecVerificationName);
		return vecVerification;
	}
	public VehicleVerification getVecVerificationbyId(Integer id) {
		VehicleVerification vecVerification = vecVerificationRepository.findById(id);
		return vecVerification;
	}
	
	public void updateVehicleVerification(VehicleVerification vecVerification) {
		vecVerificationRepository.save(vecVerification);
	}
	
	public void deleteVehicleVerification(Integer id) {
		vecVerificationRepository.delete(getVecVerificationbyId(id));
	}
	
}
