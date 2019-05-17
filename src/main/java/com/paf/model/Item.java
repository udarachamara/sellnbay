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
@Table(name = "items")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="item_id_seq")
  @SequenceGenerator(name="item_id_seq", sequenceName="item_id_seq", allocationSize=1)
  @Column(name = "ITEM_ID")
  private Long id;

  @Column(name = "ITEM_NAME")
  private String itemName;
  
  @Column(name = "ITEM_CATEGORY")
  private String itemCategory;
  
  @Column(name = "ITEM_PRICE")
  private double itemPrice;
  
  @Column(name = "ITEM_QUANTITY")
  private int itemQuantity;
  
  @Column(name = "ITEM_STATUS")
  private String itemStatus;
  
  @Column(name = "ITEM_CREATE_AT")
  private Timestamp itemCreateAt;
  
	public Item(Long id, String itemName, String itemCategory, double itemPrice, int itemQuantity, String itemStatus,
			Timestamp itemCreateAt) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemStatus = itemStatus;
		this.itemCreateAt = itemCreateAt;
	}


	Item() {
	    // Default constructor needed by JPA
	  }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemCategory() {
		return itemCategory;
	}


	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public String getItemStatus() {
		return itemStatus;
	}


	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}


	public Timestamp getItemCreateAt() {
		return itemCreateAt;
	}


	public void setItemCreateAt(Timestamp itemCreateAt) {
		this.itemCreateAt = itemCreateAt;
	}
	
	

}
