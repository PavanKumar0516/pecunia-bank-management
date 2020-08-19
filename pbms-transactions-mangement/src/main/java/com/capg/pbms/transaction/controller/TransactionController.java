package com.capg.pbms.transaction.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.exception.InvaildAccountException;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService service;

	@PostMapping("/debit/{accNumber}/{amount}")
	public Transaction debitUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InvaildAccountException, InsufficienBalanceException, AccountNotFoundException {

		return service.debitUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/credit/{accNumber}/{amount}")
	public Transaction creditUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InvaildAccountException, InsufficienBalanceException, AccountNotFoundException {
		return service.creditUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/credits/{accNumber}/{amount}")
	public Transaction creditUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException, AccountNotFoundException {
		return service.creditUsingCheque(accNumber, amount, transaction);
	}

	@PostMapping("/debits/{accNumber}/{amount}")
	public Transaction debitUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InvaildAccountException, InsufficienBalanceException, ChequeBounceException, AccountNotFoundException {
		return service.debitUsingCheque(accNumber, amount, transaction);
	}

	@GetMapping("/getAll")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}

	@GetMapping("/trans/{transId}")
	public Transaction findByTransactionId(@PathVariable("transId") int transId) throws InvaildAccountException {

		return service.findByTransactionId(transId);

	}

}
