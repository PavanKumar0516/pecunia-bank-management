package com.capg.pbms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.transaction.exception.InsufficienBalanceException;
import com.capg.pbms.transaction.model.Cheque;
import com.capg.pbms.transaction.model.Transaction;
import com.capg.pbms.transaction.service.TransactionService;

@SpringBootTest
class TransactionServiceTest {
	@Autowired
	TransactionService service;
	Transaction trans;
	Cheque cheque;

	@BeforeEach
	void setUp() {
		trans = new Transaction(121211111143l, 1212121, 50000.0, 2000, LocalDateTime.now(), 52000.0);
		cheque = new Cheque(1212123, 50000.0, 20000, LocalDateTime.now(), 52000.0);
	}

	@Test
	void testDebitUsingSlip() throws AccountNotFoundException, InsufficienBalanceException {
		Transaction transaction = service.debitUsingSlip(121211111143l, 2000, trans);
		assertEquals(transaction, trans);
	}

}
