package com.capg.pbms.transaction.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionService;
@SpringBootTest
class TransactionServiceTest {
	@Autowired
	TransactionService service;
	
		Transaction t=new Transaction();

	@Test
	void testDebitUsingSlip() {
		System.out.println(t);
	
		
	}

	@Test
	void testCreditUsingSlip() {
		fail("Not yet implemented");
	}

	@Test
	void testCreditUsingCheque() {
		fail("Not yet implemented");
	}

	@Test
	void testDebitUsingCheque() {
		fail("Not yet implemented");
	}
	@Test
	void contextLoads() {
	}


}
