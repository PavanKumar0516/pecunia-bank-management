package com.capg.pbms.transaction.model;

import java.time.LocalDateTime;


import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


/*******************************************************************************************************************************
   -Author                   :    P.AkashPawar
   -Created/Modified Date    :     14-08-2020
   -Description              :     Transaction Bean Class
 
 *******************************************************************************************************************************/

@Entity

@Table(name = "transaction_info")
public class Transaction {

	@Id
	private int transactionId;
	private long transAccountNumber;
	private double currentBalance;
	private double transactionAmount;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDateTime transactionDate;
	private double transClosingBalance;
	@OneToOne(cascade = { CascadeType.ALL })
	private Cheque chequeDetails;

	public Transaction() {

	}

	public long getTransAccountNumber() {
		return transAccountNumber;
	}

	public void setTransAccountNumber(long transAccountNumber) {
		this.transAccountNumber = transAccountNumber;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransClosingBalance() {
		return transClosingBalance;
	}

	public void setTransClosingBalance(double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}

	public Cheque getChequeDetails() {
		return chequeDetails;
	}

	public void setChequeDetails(Cheque chequeDetails) {
		this.chequeDetails = chequeDetails;
	}

	public Transaction(long transAccountNumber, int transactionId, double currentBalance, double transactionAmount,
			LocalDateTime transactionDate, double transClosingBalance) {
		super();
		this.transAccountNumber = transAccountNumber;
		this.transactionId = transactionId;
		this.currentBalance = currentBalance;
		this.transactionAmount = transactionAmount;

		this.transactionDate = transactionDate;
		this.transClosingBalance = transClosingBalance;
	}

	@Override
	public String toString() {
		return "Transaction [  transactionId=" + transactionId + ", currentBalance=" + currentBalance
				+ ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transClosingBalance=" + transClosingBalance + "]";
	}

}
