
/*
 * Project Name : PECUNIA BANK MANAGEMENT
 *
 * 
 * */
package com.capg.pbms.loan.controller;

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

import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;
import com.capg.pbms.loan.service.ILoanService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/loan")
public class LoanController {

	/*******************************************************************************************************************************
	-Author                   :     Nagasri
	-Created/Modified Date    :     20-08-2020
	-Description              :     LoanController Class for accessing Loan Management services
	*******************************************************************************************************************************/
	
	@Autowired
	ILoanService service;
	
	@PostMapping("/addAccount")
	public Customer addaccount(@RequestBody Customer account) {
		return service.addaccount(account);
	}
	
	@PostMapping("/assign/loan/id/{id}/{creditscore}/{amount}")
	
	public LoanRequest addLoan(@PathVariable("id") long accountId,@PathVariable("creditscore") int creditScore,@PathVariable("amount") double loanAmount,@RequestBody LoanRequest loanrequest)
	{
		 return service.addLoan(accountId, creditScore, loanAmount, loanrequest);		
	}
	@GetMapping("/get/{accountId}")
    public LoanRequest getByLoanId(@PathVariable("accountId") long accountId) throws AccountNotFoundException {
		return service.getLoanById(accountId);
	
}
	@GetMapping("/getAllLoans")
	public List<LoanRequest> getAllLoans()
	{
		return service.getAllLoans();
	}
 }