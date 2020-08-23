package com.capg.pbms.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.pbms.transaction.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public Transaction findByTransactionId(int transactionId);
	public Transaction findBytransAccountNumber(long transAccountNumber);

}
