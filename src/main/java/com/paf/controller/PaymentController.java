package com.paf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paf.model.Payment;
import com.paf.dao.PaymentDAO;
@RestController
public class PaymentController {

  private final PaymentDAO paymentDAO;
	  
  @Autowired
  PaymentController(PaymentDAO paymentDAO) {
	    this.paymentDAO = paymentDAO;
  }

	/* to save an payment*/
	@PostMapping("/payments")
	public Payment createPayment(@Valid @RequestBody Payment payment) {
		return paymentDAO.save(payment);
	}
	
	/*get all payments*/
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentDAO.findAll();
	}

	/*get payment by paymentid*/
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long paymentid){
		
		Payment payment= paymentDAO.findOne(paymentid);
		
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(payment);
		
	}
	
	/*update an payment by paymentid*/
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="id") Long paymentid,@Valid @RequestBody Payment paymentDetails){
		
		Payment payment=paymentDAO.findOne(paymentid);
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		
		payment.setTransactionId(paymentDetails.getTransactionId());
		payment.setPaymentMethod(paymentDetails.getPaymentMethod());
		payment.setPaymentStatus(paymentDetails.getPaymentStatus());
		payment.setPaymentCreateAt(paymentDetails.getPaymentCreateAt());
		
		Payment updateEmployee=paymentDAO.save(payment);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an payment*/
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> deleteEmployee(@PathVariable(value="id") Long paymentid){
		
		Payment payment = paymentDAO.findOne(paymentid);
		if(payment==null) {
			return ResponseEntity.notFound().build();
		}
		paymentDAO.delete(payment);
		
		return ResponseEntity.ok().build();
		
		
	}

}
