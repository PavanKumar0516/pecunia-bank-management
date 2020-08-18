package com.capg.pbms.transaction.model;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cheque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chequeId;
	private double currentBalance;
	
private double ChequeAmount;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime chequeIssueDate;
	private double chequeClosingBalance;
	private long debitAccNum;
	

	public long getDebitAccNum() {
		return debitAccNum;
	}

	public void setDebitAccNum(long debitAccNum) {
		this.debitAccNum = debitAccNum;
	}

	public Cheque() {
	}

	public Cheque(int chequeId, double currentBalance, double chequeAmount, LocalDateTime chequeIssueDate,
			double chequeClosingBalance) {
		super();

		this.chequeId = chequeId;

		this.currentBalance = currentBalance;

		ChequeAmount = chequeAmount;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeClosingBalance = chequeClosingBalance;
	}

	public int getChequeId() {
		return chequeId;
	}

	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getChequeAmount() {
		return ChequeAmount;
	}

	public void setChequeAmount(double chequeAmount) {
		ChequeAmount = chequeAmount;
	}

	public LocalDateTime getChequeIssueDate() {
		return chequeIssueDate;
	}

	public void setChequeIssueDate(LocalDateTime chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}

	public double getChequeClosingBalance() {
		return chequeClosingBalance;
	}

	public void setChequeClosingBalance(double chequeClosingBalance) {
		this.chequeClosingBalance = chequeClosingBalance;
	}

	@Override
	public String toString() {
		return "Cheque [ chequeId=" + chequeId + ", chequeHolderName=" + ", currentBalance=" + currentBalance
				+ ", chequeIfscCode=" + ", ChequeAmount=" + ChequeAmount + ", chequeIssueDate=" + chequeIssueDate
				+ ", chequeClosingBalance=" + chequeClosingBalance + "]";
	}

}
