package com.capg.pbms.transaction.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ChequeBean Class
 *
 * @author :P.AkashPawar
 * @since :2020-08-15
 */
@Entity
@Table(name = "cheque_info")
public class Cheque {
	@Id
	private int chequeId;
	private double currentBalance;
	private double ChequeAmount;
	private String chequeHolderName;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime chequeIssueDate;
	private double chequeClosingBalance;
	private long debitAccNum;

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

	public long getDebitAccNum() {
		return debitAccNum;
	}

	public void setDebitAccNum(long debitAccNum) {
		this.debitAccNum = debitAccNum;
	}

	public String getChequeHolderName() {
		return chequeHolderName;
	}

	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}

	@Override
	public String toString() {
		return "Cheque [ chequeId=" + chequeId + ", chequeHolderName=" + ", currentBalance=" + currentBalance
				+ ", chequeIfscCode=" + ", ChequeAmount=" + ChequeAmount + ", chequeIssueDate=" + chequeIssueDate
				+ ", chequeClosingBalance=" + chequeClosingBalance + "]";
	}

}
