package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.repository.DriRepository;
import com.techm.transport.vendor.repository.VecTypeRepository;
@Service
public class VehicleTypeService extends BaseService{

	@Autowired
	private VecTypeRepository vecTypeRepository;

	public List<VehicleType> getAllVehicleTypes(){
		List<VehicleType> list = new ArrayList<VehicleType>();

		Iterator<VehicleType> itr = vecTypeRepository.findAll().iterator();
		while(itr.hasNext()) {
			list.add(itr.next()); 
		}
		return list;
	}

	public synchronized boolean addVehicleType(String vecType) {
		VehicleType dbVecType = getVecTypebyName(vecType); 	
		if (dbVecType!=null) {
			return false;
		} else {
			VehicleType type = new VehicleType();
			type.setVecTypeName(vecType);
			vecTypeRepository.save(type);
			return true;
		}
	}
	
	public VehicleType getVecTypebyName(String vecTypeName) {
		VehicleType vecType = vecTypeRepository.findByVecTypeName(vecTypeName);
		return vecType;
	}
	public VehicleType getVecTypebyId(Integer id) {
		VehicleType vecType = vecTypeRepository.findByvId(id);
		return vecType;
	}
	
	public void updateVehicleType(VehicleType vecType) {
		vecTypeRepository.save(vecType);
	}
	
	public void deleteVehicleType(Integer id) {
		vecTypeRepository.delete(getVecTypebyId(id));
	}
	
}
