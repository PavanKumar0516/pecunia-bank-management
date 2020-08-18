package com.capg.pbms.transaction.service;

import java.util.List;

import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.exception.InvaildAccountException;
import com.capg.pbms.transaction.model.Transaction;

public interface ITransactionService {

	Transaction debitUsingSlip(long accNUmber, double amount, Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException;

	Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException;

	Transaction creditUsingCheque(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException;

	Transaction debitUsingCheque(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, ChequeBounceException;

	List<Transaction> getAllTransaction();

}
