package com.capg.pbms.passbook.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Cheque {
	@Id
	//private Long ChequeAccountNumber=(long) new Random().nextInt(1000000000);;
@GeneratedValue(strategy = GenerationType.AUTO)
	private int chequeId;
	private double currentBalance;
	private double ChequeAmount;
	@DateTimeFormat(pattern="yyyy/MM/ddThh:mm:ss")
	private LocalDate chequeIssueDate;
	private double chequeClosingBalance;
	private String chequeHolderName;
	
	
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}
	
	public Cheque( int chequeId, double currentBalance,
	 double chequeAmount, LocalDate chequeIssueDate, double chequeClosingBalance) {
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

	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}

	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}

	public double getChequeClosingBalance() {
		return chequeClosingBalance;
	}

	public void setChequeClosingBalance(double chequeClosingBalance) {
		this.chequeClosingBalance = chequeClosingBalance;
	}

	
	
	public String getChequeHolderName() {
		return chequeHolderName;
	}

	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}

	@Override
	public String toString() {
		return "Cheque [ chequeId=" + chequeId + ", chequeHolderName="
				+ ", currentBalance=" + currentBalance + ", chequeIfscCode=" 
				+ ", ChequeAmount=" + ChequeAmount + ", chequeIssueDate=" + chequeIssueDate + ", chequeClosingBalance="
				+ chequeClosingBalance + "]";
	}




	
	


}
