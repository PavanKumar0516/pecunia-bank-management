package com.capg.pbms.loan.service;

import java.util.List;
import java.util.Random;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.loan.exception.AccountException;
import com.capg.pbms.loan.model.BankAccountDetails;
import com.capg.pbms.loan.model.LoanRequest;
import com.capg.pbms.loan.repo.ILoanRequestRepo;

@Service
public class LoanServiceImpl implements ILoanService {

	
	@Autowired
	ILoanRequestRepo repo1;

	@Autowired
	RestTemplate rt;
	
	/******************************************************************************************************************************************************
	 * -FunctionName       : addLoan() 
	 * -Input Parameters   : LoanID,Amount,LoanRequest,creditscore Object 
	 * -Throws             : AccountNotFoundException
	 * -Description        : Adding Loan Details
	 *******************************************************************************************************************************************************/

	@Override
	public LoanRequest addLoan(long accountId, int creditScore, double loanAmount, LoanRequest loanrequest) {

    BankAccountDetails bank = rt.getForObject("http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accountId,BankAccountDetails.class);
//    if(accountId!=bank.getAccNumber()) {
//		throw new AccountNotFoundException("Account number not found");
//	}
    loanrequest.setLoanRequestId(bank.getAccNumber());
    if (creditScore < 670 && (loanAmount < 100000 || loanAmount > 10000000))
    {
    	loanrequest.setLoanStatus("Rejected");
		return loanrequest;
	}
		
		long id = Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12));
		return repo1.save(loanrequest);
	}

	/********************************************************************************************************************************************************
	 * -FunctionName     : getLoanById() 
	 * -Input Parameters : accountId 
	 * -Throws           : AccountNotFoundException
	 * -Description      : Fetches LoanDetails from Database based on accountId
	 ********************************************************************************************************************************************************/
	public LoanRequest getLoanById(long accountId) throws AccountNotFoundException
	{
	     if (!repo1.existsById(accountId)) 
	        {
			      throw new AccountNotFoundException("account number doesn't exists");
	        }
		  return repo1.getOne(accountId);
	}
	
	public List<LoanRequest> getAllLoans()
	{
		return repo1.findAll();
	}

}