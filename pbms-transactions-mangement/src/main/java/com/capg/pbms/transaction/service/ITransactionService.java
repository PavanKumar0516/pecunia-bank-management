package com.capg.pbms.transaction.service;

import java.util.List;
import javax.security.auth.login.AccountNotFoundException;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.Transaction;

/*******************************************************************************************************************************
 * -Author : P.AkashPawar -Created/Modified Date : 18-08-2020 -Description :
 * TransactionService Interface with services for Transaction Management System
 *******************************************************************************************************************************/

public interface ITransactionService {

	Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException;

	Transaction creditUsingCheque(long accNumber, double amount, Transaction transaction)
			throws AccountNotFoundException, ChequeBounceException;

	Transaction debitUsingCheque(long accNumber, double amount, Transaction transaction)
			throws ChequeBounceException, AccountNotFoundException;

	List<Transaction> getAllTransaction();

}
