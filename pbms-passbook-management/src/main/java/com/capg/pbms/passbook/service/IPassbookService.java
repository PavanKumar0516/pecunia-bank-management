package com.capg.pbms.passbook.service;

import java.util.List;

import com.capg.pbms.passbook.model.Transaction;

public interface IPassbookService {
List<Transaction> getAllTransactions();

Transaction getTransactionByTransactionId(int transactionId);
}
