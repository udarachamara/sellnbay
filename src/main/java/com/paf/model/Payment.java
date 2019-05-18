package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_id_seq")
  @SequenceGenerator(name="payment_id_seq", sequenceName="payment_id_seq", allocationSize=1)
  @Column(name = "PAYMENTID")
  private Long id;

  @Column(name = "ORDER_ID")
  private int orderId;
  
  @Column(name = "PAYMENT_METHOD")
  private String paymentMethod;
  
  @Column(name = "TRANSACTION_ID")
  private int transactionId;
  
  @Column(name = "PAYMENT_STATUS")
  private int paymentStatus;
  
  @Column(name = "PAYMENT_CREATE_AT")
  private Timestamp paymentCreateAt;

  

  public Payment(Long id, int orderId,int transactionId,String paymentMethod, int paymentStatus, Timestamp paymentCreateAt) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.transactionId = transactionId;
	this.paymentMethod = paymentMethod;
	this.paymentStatus = paymentStatus;
	this.paymentCreateAt = paymentCreateAt;
}


Payment() {
    // Default constructor needed by JPA
  }


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public int getOrderId() {
	return orderId;
}


public void setOrderId(int orderId) {
	this.orderId = orderId;
}


public int getTransactionId() {
	return transactionId;
}


public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}


public String getPaymentMethod() {
	return paymentMethod;
}


public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}


public int getPaymentStatus() {
	return paymentStatus;
}


public void setPaymentStatus(int paymentStatus) {
	this.paymentStatus = paymentStatus;
}


public Timestamp getPaymentCreateAt() {
	return paymentCreateAt;
}


public void setPaymentCreateAt(Timestamp paymentCreateAt) {
	this.paymentCreateAt = paymentCreateAt;
}



}
