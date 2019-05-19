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
@Table(name = "delivery")
public class Delivery {
	 @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="delivery_id_seq")
	  @SequenceGenerator(name="delivery_id_seq", sequenceName="delivery_id_seq", allocationSize=1)
	  @Column(name = "Deliver_ID")
	  private String DeliverId;

	  @Column(name = "Deliver_Name")
	  private String DeliverName;
	  
	  @Column(name = "Mobile")
	  private String Mobile;
	  
	  @Column(name = "Order_ID")
	  private String OrderId;

	  @Column(name = "Delivery_date")
	  private String DeliveryDate;
	  
	  @Column(name = "Delivery_status")
	  private String DeliveryStatus;
	  
	  @Column(name = "Delivery_Address")
	  private String DeliveryAddress;
	  
	  
	


	public Delivery(String DeliverId, String DeliverName, String Mobile,String DeliveryStatus,String DeliveryDate,String OrderId,String DeliveryAddress) {
		super();
		this.DeliverId =DeliverId;
		this.DeliverName = DeliverName;
		this.Mobile =Mobile;
		this.DeliveryDate =DeliveryDate;
		this.DeliveryStatus = DeliveryStatus;
		this.OrderId =OrderId;
		this.DeliveryAddress =DeliveryAddress;
	}


	Delivery() {
	    // Default constructor needed by JPA
	  }
	public String getDeliverId() {
		return DeliverId ;
	}

	public void setDeliverId(String DeliverId) {
		this.DeliverId = DeliverId;
		
	}
	
	public String getDeliverName() {
		return DeliverName ;
	}
	public void setDeliverName(String  DeliverName) {
		this. DeliverName =  DeliverName;
	}


	public String getMobile() {
		return Mobile ;
	}
	


	public void setMobile(String Mobile) {
		this.Mobile= Mobile;
	}
	public String getOrderId() {
		return OrderId ;
	}
	


	public void setOrderId(String OrderId) {
		this.OrderId= OrderId;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress ;
	}
	


	public void setDeliveryAddress(String DeliveryAddress) {
		this.DeliveryAddress= DeliveryAddress;
	}
   
	public String getDeliveryDate() {
		return DeliveryDate ;
	}
	


	public void setDeliveryDate(String DeliveryDate) {
		this.DeliveryDate= DeliveryDate;
		
	}
	public String DeliveryStatus() {
		return DeliveryStatus ;
	}
	


	public void setDeliveryStatus(String DeliveryStatus) {
		this.DeliveryStatus= DeliveryStatus;
		
	}






}
