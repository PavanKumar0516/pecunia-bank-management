package com.capg.pbms.transaction.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.exception.InvaildAccountException;
import com.capg.pbms.transaction.model.Transaction;

public interface ITransactionService {

	Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingCheque(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, AccountNotFoundException;

	Transaction debitUsingCheque(long accNumber, double amount, Transaction transaction)
			throws InvaildAccountException, ChequeBounceException, AccountNotFoundException;

	List<Transaction> getAllTransaction();

}
