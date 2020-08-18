package com.capg.pbms.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.pbms.transaction.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
	
	//@Query("from transaction_info where transactionId:transactionId")
	public Transaction findByTransactionId(int transactionId);

}
