package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Delivery;
import com.paf.repository.delivery.DeliveryRepository;


@Service
public class DeliveryDAO {
	@Autowired
	DeliveryRepository deliveryRepository;
	
	/*to save an delivery*/
	
	public Delivery save(String delivery) {
		return DeliveryRepository.save(delivery);
	}
	
	
	/* search all delivery*/
	
	public List<Delivery> findAll(){
		return DeliveryRepository.findAll();
	}
	
	
	/*get an delivery by id*/
	public Delivery findOne(String DeliverId) {
		return DeliveryRepository.findOne(String DeliverId);
	}
	
	
	/*delete an delivery*/
	
	public void delete(Delivery delivery) {
		DeliveryRepository.delete(delivery);
	}

}
