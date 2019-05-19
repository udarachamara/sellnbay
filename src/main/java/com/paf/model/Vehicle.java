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
@Table(name = "vehicle")
public class Vehicle {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "Vehicle_ID")
	  private String VehicleId;

	  @Column(name = "Vehicle_Number")
	  private String VehicleNumber;
	  
	  @Column(name = "Vehicle_Type")
	  private String VehicleType;
	 
	 


	public Vehicle(String VehicleId, String VehicleNumber, String VehicleType)
			 {
		super();
		this.VehicleId = VehicleId;
		this.VehicleNumber = VehicleNumber;
		this. VehicleType=VehicleType;
		
	}


	Vehicle() {
	    // Default constructor needed by JPA
	  }


	public String getVehicleId() {
		return VehicleId ;
	}


	public void setVehicleId(String VehicleId) {
		this.VehicleId = VehicleId;
	}


	public String getVehicleNumber() {
		return VehicleNumber ;
	}


	public void setVehicleNumber(String VehicleNumber) {
		this.VehicleNumber= VehicleNumber;
	}



	public String getVehicleType() {
		return VehicleType;
	}


	public void setVehicleType(String VehicleType) {
		this.VehicleType = VehicleType;
	}
}
