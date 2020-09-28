package com.capg.pbms.loan.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.loan.model.LoanRequest;

@SpringBootTest
class LoanServiceImplTest {

	@Autowired
	ILoanService service;
	
	@Test
	void testAddLoan1() {
		LoanRequest loanrequest=new LoanRequest(510744551037L, 2, "house loan", 3, 300.00, "Accepted", 500.00, 680);
		assertEquals("Rejected",service.addLoan(369487823202L, 650, 10000, loanrequest).getLoanStatus());
	}
	
	@Test
	void testAddLoan2() {
		LoanRequest loanrequest=new LoanRequest(510744551037L, 2, "house loan", 3, 300.00, "Accepted", 500.00, 680);
		assertEquals("Accepted",service.addLoan(369487823202L, 680, 10000, loanrequest).getLoanStatus());
	}

	@Test
	void testGetLoanById()  throws AccountNotFoundException {	
		assertEquals(true, service.getLoanById(369487823202L)!=null);
	}
	
	@Test
	void testGetLoanByIdExceptionCase()
	{
		Assertions.assertThrows(AccountNotFoundException.class, () -> {
			service.getLoanById(369487823201L);
		    });
	}

	@Test
	void testGetAllLoans() {
	
	}

}
