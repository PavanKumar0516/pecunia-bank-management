package com.capg.pbms.transaction.service;

import java.util.List;
import javax.security.auth.login.AccountNotFoundException;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.Transaction;

/**
 * The TransactionService Interface for accessing Transaction Management System
 *
 * @author :P.AkashPawar
 * @since :2020-08-18
 */
public interface ITransactionService {

	Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingCheque(long accNumber, double amount, Transaction transaction)
			throws AccountNotFoundException, ChequeBounceException;

	Transaction debitUsingCheque(long accNumber, double amount, Transaction transaction)
			throws ChequeBounceException, AccountNotFoundException;

	List<Transaction> getAllTransactions(long accNumber);

}
