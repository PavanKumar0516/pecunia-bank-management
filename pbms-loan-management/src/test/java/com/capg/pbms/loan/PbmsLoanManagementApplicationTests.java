package com.capg.pbms.loan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.loan.service.ILoanService;

@SpringBootTest
class PbmsLoanManagementApplicationTests {

	@Autowired
	ILoanService service;
	
	@Test
	void contextLoads() throws AccountNotFoundException {
		assertEquals(true, service.getLoanById(369487823202L)!=null);
	}
	
	
}
