package com.capg.pbms.loan.service;

import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanService {
	
	//public Customer addaccount(Customer account);
	public Customer accountinfo(long accountId);
	public LoanRequest addLoan(long accountId,int creditScore,double loanAmount,LoanRequest loanrequest);
	public LoanRequest getLoanById(long accountId);
}