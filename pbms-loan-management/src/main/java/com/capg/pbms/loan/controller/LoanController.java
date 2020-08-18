package com.capg.pbms.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.loan.model.LoanRequest;
import com.capg.pbms.loan.service.ILoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	ILoanService service;
	//@PostMapping("/addAccount")
	//public Customer addaccount(@RequestBody Customer account) {
	//	return service.addaccount(account);
	//}

	@PostMapping("/assign/loan/id/{id}/{creditscore}/{amount}")
	
	public LoanRequest addLoan(@PathVariable("id") long accountId,@PathVariable("creditscore") int creditScore,@PathVariable("amount") double loanAmount,@RequestBody LoanRequest loanrequest)
	{
		 return service.addLoan(accountId, creditScore, loanAmount, loanrequest);		
	}
	
	
 }