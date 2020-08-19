package com.capg.pbms.loan.service;

import javax.security.auth.login.AccountNotFoundException;

import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanService {
	public LoanRequest addLoan(long accountId,int creditScore,double loanAmount,LoanRequest loanrequest);
	public LoanRequest getLoanById(long accountId) throws AccountNotFoundException;
}