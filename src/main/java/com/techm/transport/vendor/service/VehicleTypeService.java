package com.techm.transport.vendor.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.repository.VecTypeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
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

	public synchronized VehicleType addVehicleType(VehicleType vecType) {
		VehicleType dbVecType = vecTypeRepository.findByvId(vecType.getvId()); 	
		/*if (dbVecType!=null) {
			return false;
		} else {
			//VehicleType type = new VehicleType();
			//type.setVecTypeName(vecType);
			vecTypeRepository.save(vecType);
			return true;
		}*/
		
		if (dbVecType==null) {
			vecTypeRepository.save(vecType);
			return vecType;
		} 
		else 
		{
			
			return vecType;
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
