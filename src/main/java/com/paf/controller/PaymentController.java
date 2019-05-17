package com.paf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.paf.model.Payment;
import com.paf.dao.ItemDAO;
import com.paf.dao.PaymentDAO;
@RestController
public class PaymentController {

  private final PaymentDAO paymentDAO;
	  
  @Autowired
  PaymentController(PaymentDAO paymentDAO) {
	    this.paymentDAO = paymentDAO;
  }

  @RequestMapping("/payment/{id}")
  public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) {
	  
	  Payment payment = paymentDAO.findOne(id);
	    
	    if(payment == null) {
	    	return ResponseEntity.notFound().build();
	    }
	    
	    return ResponseEntity.ok().body(payment);
  }

}
