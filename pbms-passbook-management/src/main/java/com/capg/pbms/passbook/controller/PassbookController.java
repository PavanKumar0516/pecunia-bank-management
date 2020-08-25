package com.capg.pbms.passbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.passbook.model.Transaction;
import com.capg.pbms.passbook.service.IPassbookService;
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/passbook")
public class PassbookController {
	@Autowired
	private IPassbookService passbookService;
	@GetMapping("/getalltransactions")
	public List<Transaction> getAllTransactions()
	{
	return passbookService.getAllTransactions();
	}
	@GetMapping("/gettransactionbyid/transactionId/{transactionId}")
	public Transaction getTransactionByTransactionId(@PathVariable int transactionId)
	{
		return passbookService.getTransactionByTransactionId(transactionId);
	}
	@GetMapping("/getalltransactions/{accNumber}")
	public List<Transaction> getAllTransactions(@PathVariable ("accNumber") long accNumber)
	{
	return passbookService.getTrasactionByAccountNumber(accNumber);
	}

}
