package com.capg.pbms.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.pbms.transaction.model.Transaction;

/**
 * The TransactionRepo Interface for accessing Transaction Management System
 *
 * @author :P.AkashPawar
 * @since :2020-08-18
 */
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
