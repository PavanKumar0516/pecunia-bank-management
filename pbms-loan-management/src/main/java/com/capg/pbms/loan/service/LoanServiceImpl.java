package com.capg.pbms.loan.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.loan.exception.AccountException;
import com.capg.pbms.loan.model.BankAccountDetails;
import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;
import com.capg.pbms.loan.repo.IAccountRepo;
import com.capg.pbms.loan.repo.ILoanRequestRepo;

@Service
public class LoanServiceImpl implements ILoanService {

 	@Autowired
	IAccountRepo repo;
	@Autowired
	ILoanRequestRepo repo1;


	
 	@Autowired
 	RestTemplate rt;
	
 	/*@Override
	public Customer addaccount(Customer account) {
		if(repo.existsById(account.getAccountId())) {
			throw new AccountException("Account Already exists");
		}
		return repo.save(account);
	}*/
	
	@Override
	public Customer accountinfo(long accountId) {
		Customer account=repo.getOne(accountId);
		if(!repo.existsById(accountId)) {
			throw new AccountException("Account Does not exists");
		}
		return repo.getOne(accountId);
	}

	@Override
	public LoanRequest addLoan(long accountId,int creditScore,double loanAmount,LoanRequest loanrequest) {
		
		BankAccountDetails bank=rt.getForObject("http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/"+accountId, BankAccountDetails.class);

	
		  if(!(isValidAccountId(accountId))==true) { throw new
		  AccountException("Invalid accountID"); }
		
		
		loanrequest.setLoanRequestId(bank.getAccNumber());
		if(creditScore<670 && (loanAmount<100000 || loanAmount>10000000)) {
			throw new AccountException("can't approve loan request due to less creditScore");
		}
		long id=Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12));
				return repo1.save(loanrequest);
	}
	
	public LoanRequest getLoanById(long accountId) {
		return repo1.getOne(accountId);
	}
	
	public boolean isValidAccountId(long accountId) {
		String str=String.valueOf(accountId);
		if(str.matches("[0-9]{12}")) {
		return true;	
		}
		
	throw new AccountException("Invalid Account Id");	 
	}
 
}