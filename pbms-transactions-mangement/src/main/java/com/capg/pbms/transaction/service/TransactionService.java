package com.capg.pbms.transaction.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.BankAccountDetails;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.repo.TransactionRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/*******************************************************************************************************************************
-Author                   :     P.AkashPawar
-Created/Modified Date    :     17-08-2020
-Description              :     TransactionServiceImpl Class implements services for Transaction Management System
*******************************************************************************************************************************/

@Service
@Transactional
public class TransactionService implements ITransactionService {

	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "debitUsingSlipFallBack")
	public Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException {
		BankAccountDetails bankDetails = restTemplate.getForObject(
				"http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accNumber, BankAccountDetails.class);
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		if (accNumber != bankDetails.getAccNumber()) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		transaction.setCurrentBalance(bankDetails.getAccountBalance());
		if (amount > transaction.getCurrentBalance()) {
			throw new InsufficienBalanceException("Amount should be more than 100 and less than current balance");
		}

		transaction.setTransactionId(
				Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.setTransClosingBalance(transaction.getCurrentBalance() - amount);
		transaction.setTransactionAmount(transaction.getCurrentBalance() - transaction.getTransClosingBalance());
		transaction.setTransactionDate(LocalDateTime.now());
		return transactionRepo.save(transaction);
	}

	public Transaction debitUsingSlipFallBack(long accNumber, double amount, Transaction transaction) {
		Transaction transaction1 = new Transaction(transaction.getTransAccountNumber(), 1, 50000.0, 2000.0,
				transaction.getTransactionDate(), 89000.0);
		return transaction1;

	}

	@Override
	public Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException {

		BankAccountDetails bankDetails = restTemplate.getForObject(
				"http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accNumber, BankAccountDetails.class);

		if (accNumber != bankDetails.getAccNumber()) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		if (amount > 100000) {
			throw new InsufficienBalanceException("amount should be less than 1 lakh");
		}
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		transaction.setCurrentBalance(bankDetails.getAccountBalance());

		transaction.setTransactionId(
				Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.setTransClosingBalance(transaction.getCurrentBalance() + amount);
		transaction.setTransactionAmount(transaction.getTransClosingBalance() - transaction.getCurrentBalance());
		transaction.setTransactionDate(LocalDateTime.now());
		return transactionRepo.save(transaction);
	}

	@Override
	public Transaction creditUsingCheque(long accNumber, double amount, Transaction transaction)
			throws AccountNotFoundException, ChequeBounceException {

		BankAccountDetails bankDetails = restTemplate.getForObject(
				"http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accNumber, BankAccountDetails.class);

		if (accNumber != bankDetails.getAccNumber()) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		if (amount > 100000) {
			throw new ChequeBounceException("Amount should be maintained as per bank orders");
		}
		transaction.getChequeDetails().setCurrentBalance(bankDetails.getAccountBalance());

		transaction.setTransactionId(
				Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.getChequeDetails()
				.setDebitAccNum(Long.parseLong((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12))));
		transaction.getChequeDetails()
				.setChequeId(Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		
		transaction.getChequeDetails().setChequeIssueDate(LocalDateTime.now());
		transaction.getChequeDetails().setChequeAmount(amount);
		transaction.getChequeDetails().getChequeHolderName();
		
		transaction.getChequeDetails().setChequeClosingBalance(
				transaction.getChequeDetails().getCurrentBalance() + transaction.getChequeDetails().getChequeAmount());
		return transactionRepo.save(transaction);

	}

	@Override
	public List<Transaction> getAllTransaction() {

		return transactionRepo.findAll();
	}

	@Override
	public Transaction debitUsingCheque(long accNumber, double amount, Transaction transaction)
			throws ChequeBounceException, AccountNotFoundException {
		BankAccountDetails bankDetails = restTemplate.getForObject(
				"http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accNumber, BankAccountDetails.class);
		if (accNumber != bankDetails.getAccNumber()) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		transaction.getChequeDetails().setCurrentBalance(bankDetails.getAccountBalance());
		transaction.getChequeDetails().setChequeIssueDate(LocalDateTime.now());
		if (amount > 100000) {
			throw new ChequeBounceException("Amount should be less than 1 lakh");

		}

		transaction.setTransactionId(
				Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));

		transaction.getChequeDetails()
				.setDebitAccNum(Long.parseLong((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12))));

		transaction.getChequeDetails()
				.setChequeId(Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.getChequeDetails().setChequeAmount(amount);
		transaction.getChequeDetails().getChequeHolderName();
		transaction.getChequeDetails().setChequeClosingBalance(
				transaction.getChequeDetails().getCurrentBalance() - transaction.getChequeDetails().getChequeAmount());
		return transactionRepo.save(transaction);

	}

	public Transaction findByTransactionId(int transactionId) throws AccountNotFoundException {
		Transaction transaction = transactionRepo.findByTransactionId(transactionId);
		if (transaction == null) {
			throw new AccountNotFoundException("transactionId not found");
		}
		return transaction;

	}
	@Override
	public List<Transaction> getAllTransactions(long accNumber) {
		// TODO Auto-generated method stub
		List<Transaction> transactions=transactionRepo.findAll();
		List<Transaction> transactionList=new ArrayList<>();
		for (Transaction transaction : transactions) {
			if(transaction.getTransAccountNumber()==accNumber)
			{
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}

}
