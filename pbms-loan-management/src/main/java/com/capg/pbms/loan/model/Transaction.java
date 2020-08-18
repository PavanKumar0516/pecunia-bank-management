package com.capg.pbms.loan.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="transaction_info")
public class Transaction {
	
	@Id
	private long transAccountId; 
	private long transaction_id;
	private double transAmount;
	private String transOption;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate transDate;
 	private long transChequeId;
	private double transClosingBalance;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="transaction")
	private List<Cheque> chequeList;
	
	 
	public Transaction() {
		super();
	}


	public long getTransAccountId() {
		return transAccountId;
	}


	public void setTransAccountId(long transAccountId) {
		this.transAccountId = transAccountId;
	}


	public long getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}


	public double getTransAmount() {
		return transAmount;
	}


	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}


	public String getTransOption() {
		return transOption;
	}


	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}


	public LocalDate getTransDate() {
		return transDate;
	}


	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}


	public long getTransChequeId() {
		return transChequeId;
	}


	public void setTransChequeId(long transChequeId) {
		this.transChequeId = transChequeId;
	}


	public double getTransClosingBalance() {
		return transClosingBalance;
	}


	public void setTransClosingBalance(double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}


	public List<Cheque> getChequeList() {
		return chequeList;
	}


	public void setChequeList(List<Cheque> chequeList) {
		this.chequeList = chequeList;
	}


	public Transaction(long transAccountId, long transaction_id, double transAmount, String transOption,
			LocalDate transDate, long transChequeId, double transClosingBalance, List<Cheque> chequeList) {
		super();
		this.transAccountId = transAccountId;
		this.transaction_id = transaction_id;
		this.transAmount = transAmount;
		this.transOption = transOption;
		this.transDate = transDate;
		this.transChequeId = transChequeId;
		this.transClosingBalance = transClosingBalance;
		this.chequeList = chequeList;
	}


	@Override
	public String toString() {
		return "Transaction [transAccountId=" + transAccountId + ", transaction_id=" + transaction_id + ", transAmount="
				+ transAmount + ", transOption=" + transOption + ", transDate=" + transDate + ", transChequeId="
				+ transChequeId + ", transClosingBalance=" + transClosingBalance + ", chequeList=" + chequeList + "]";
	}


	 	
 	  }