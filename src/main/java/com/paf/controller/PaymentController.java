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
import org.springframework.web.client.RestTemplate;

import com.paf.model.Payment;
import com.paf.model.PaymentRequest;
import com.paf.model.SuccessResponse;
import com.google.gson.Gson;
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
		final String uri = "http://localhost:8080/accounts/makePayment";
		
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setPublicKey("12345");
		paymentRequest.setPrivateKey("123456789");
		paymentRequest.setAmount(500);
		paymentRequest.setCardNo("1234567887654321");
		paymentRequest.setCvc(333);
		paymentRequest.setCardExpiredAt("2021-05-10");

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = restTemplate.postForEntity( uri, paymentRequest, String.class );
		
		Gson gson = new Gson();
		SuccessResponse responseData = gson.fromJson(response.getBody().toString(), SuccessResponse.class);
		
		if(responseData.getStatus() == true) {
			return paymentDAO.save(payment);
		}
		
		return payment;
		
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
		
		Payment updatePayment=paymentDAO.save(payment);
		return ResponseEntity.ok().body(updatePayment);
		
		
		
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
