package com.paf.model;

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

  @Column(name = "BAR")
  private String bar;


  Payment() {
    // Default constructor needed by JPA
  }

}
