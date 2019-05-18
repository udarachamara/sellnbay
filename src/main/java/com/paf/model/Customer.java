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
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_id_seq")
  @SequenceGenerator(name="customer_id_seq", sequenceName="customer_id_seq", allocationSize=1)
  @Column(name = "CUSTOMER_ID")
  private int id;

  @Column(name = "CUSTOMER_FNAME")
  private String fname;
  
  @Column(name = "CUSTOMER_LNAME")
  private String lname;
  
  @Column(name = "CUSTOMER_PHONE")
  private String phone;
  
  @Column(name = "CUSTOMER_ADDRESS")
  private String address;
  
  @Column(name = "CUSTOMER_STATUS")
  private String customerStatus;
  
  @Column(name = "CUSTOMER_CREATE_AT")
  private Timestamp customerCreateAt;



public Customer(int id, String fname, String lname, String phone, String address, String customerStatus,
		Timestamp customerCreateAt) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.phone = phone;
	this.address = address;
	this.customerStatus = customerStatus;
	this.customerCreateAt = customerCreateAt;
}


Customer() {
    // Default constructor needed by JPA
  }


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getFname() {
	return fname;
}


public void setFname(String fname) {
	this.fname = fname;
}


public String getLname() {
	return lname;
}


public void setLname(String lname) {
	this.lname = lname;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getCustomerStatus() {
	return customerStatus;
}


public void setCustomerStatus(String customerStatus) {
	this.customerStatus = customerStatus;
}


public Timestamp getCustomerCreateAt() {
	return customerCreateAt;
}


public void setCustomerCreateAt(Timestamp customerCreateAt) {
	this.customerCreateAt = customerCreateAt;
}


}
