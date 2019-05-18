package com.paf.repository.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
