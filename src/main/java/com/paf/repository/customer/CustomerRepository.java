package com.paf.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
