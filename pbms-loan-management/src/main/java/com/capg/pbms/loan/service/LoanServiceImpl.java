package com.capg.pbms.loan.service;

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

	@Override
	public LoanRequest addLoan(long accountId, int creditScore, double loanAmount, LoanRequest loanrequest) {

		BankAccountDetails bank = rt.getForObject("http://PBMS-ACCOUNT-MANAGEMENT/pecuniabank/get/accNum/" + accountId,
				BankAccountDetails.class);

		loanrequest.setLoanRequestId(bank.getAccNumber());
		if (creditScore < 670 && (loanAmount < 100000 || loanAmount > 10000000)) {
			throw new AccountException("can't approve loan request due to less creditScore");
		}
		long id = Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12));
		return repo1.save(loanrequest);
	}

	// @HystrixCommand(fallbackMethod = "getLoanByIdFallBack")
	public LoanRequest getLoanById(long accountId) throws AccountNotFoundException {
		if (!repo1.existsById(accountId)) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		return repo1.getOne(accountId);
	}

}