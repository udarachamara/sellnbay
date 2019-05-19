package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.paf.model.delivery;
import com.paf.model.vehicle;
import com.paf.repository.vehicle.VehicleRepository;

public class vehicleDAO {@Autowired
	VehicleRepository VehicleRepository;
	
	/*to save an delivery*/
	
	public delivery save(long delivery) {
		return  VehicleRepository.save(delivery);
	}
	
	
	/* search all delivery*/
	
	public List<vehicle> findAll(){
		return VehicleRepository.findAll();
	}
	
	
	/*get an vehicle by id*/
	public vehicle findOne(Long DeliverId) {
		return VehicleRepository.findOne();
		

		/*vehicle an delivery*/
		
	public void delete(long delivery) {
			VehicleRepository.delete(delivery);
		}

}
