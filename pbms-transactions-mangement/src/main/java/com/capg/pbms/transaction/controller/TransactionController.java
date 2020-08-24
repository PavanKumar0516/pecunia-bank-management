package com.capg.pbms.transaction.controller;

import java.util.List;


import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.pbms.transaction.exception.ChequeBounceException;
import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionService;



/*******************************************************************************************************************************
-Author                   :     P.AkashPawar
-Created/Modified Date    :     22-08-2020
-Description              :     TransactionController Class for accessing Transaction Management System services
*******************************************************************************************************************************/

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/transaction")

public class TransactionController {

	@Autowired
	TransactionService service;

	@PostMapping("/debitwithslip/{accNumber}/amount/{amount}")
	public Transaction debitUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficienBalanceException, AccountNotFoundException {

		return service.debitUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/creditwithslip/{accNumber}/amount/{amount}")
	public Transaction creditUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficienBalanceException, AccountNotFoundException {
		return service.creditUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/creditwithcheque/{accNumber}/amount/{amount}")
	public Transaction creditUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InsufficienBalanceException, AccountNotFoundException, ChequeBounceException {
		return service.creditUsingCheque(accNumber, amount, transaction);
	}

	@PostMapping("/debitwithcheque/{accNumber}/amount/{amount}")
	public Transaction debitUsingCheque(@PathVariable("accNumber") long accNumber,
			@PathVariable("amount") double amount, @RequestBody Transaction transaction)
			throws InsufficienBalanceException, ChequeBounceException, AccountNotFoundException {
		return service.debitUsingCheque(accNumber, amount, transaction);
	}

	@GetMapping("/getAll")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}

	@GetMapping("/trans/{transId}")
	public Transaction findByTransactionId(@PathVariable("transId") int transId) throws AccountNotFoundException {

		return service.findByTransactionId(transId);

	}

	@GetMapping("/trans/getAll/{accNumber}")
	public Transaction fingByTransactionNumber(@PathVariable("accNumber") long accNumber)
			throws AccountNotFoundException {
		return service.findByTransactionNumber(accNumber);

	}

}
