package com.capg.pbms.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.capg.pbms.transaction.model.Transaction;


/*******************************************************************************************************************************
-Author                   :     P.AkashPawar
-Created/Modified Date    :     16-08-2020
-Description              :     Transaction Repository Interface with Transaction as Type and Integer as PrimaryKey
*******************************************************************************************************************************/

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public Transaction findByTransactionId(int transactionId);
	public Transaction findBytransAccountNumber(long transAccountNumber);

}
