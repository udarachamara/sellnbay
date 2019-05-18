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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PAYMENT_ID")
  private int id;

  @Column(name = "ORDER_ID")
  private int orderId;
  
  @Column(name = "PAYMENT_METHOD")
  private String paymentMethod;
  
  @Column(name = "TRANSACTION_ID")
  private int transactionId;
  
  @Column(name = "PAYMENT_STATUS")
  private String paymentStatus;
  
  @Column(name = "PAYMENT_CREATE_AT")
  private Timestamp paymentCreateAt;

  

  public Payment(int id, int orderId,int transactionId,String paymentMethod, String paymentStatus, Timestamp paymentCreateAt) {
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


public int getId() {
	return id;
}


public void setId(int id) {
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


public String getPaymentStatus() {
	return paymentStatus;
}


public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}


public Timestamp getPaymentCreateAt() {
	return paymentCreateAt;
}


public void setPaymentCreateAt(Timestamp paymentCreateAt) {
	this.paymentCreateAt = paymentCreateAt;
}



}
