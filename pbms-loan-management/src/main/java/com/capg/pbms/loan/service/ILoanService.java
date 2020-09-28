package com.capg.pbms.loan.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanService {
	
	/*******************************************************************************************************************************
	 * -Author                 :  Nagasri
	   -Created/Modified Date  :  20-08-2020 
	   -Description            :  LoanService Interface with services for Loan Management 
	 *******************************************************************************************************************************/
	public LoanRequest addLoan(long accountId,int creditScore,double loanAmount,LoanRequest loanrequest);
	public LoanRequest getLoanById(long accountId) throws AccountNotFoundException;
	public List<LoanRequest> getAllLoans();
}