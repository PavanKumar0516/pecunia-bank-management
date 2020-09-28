package com.capg.pbms.loan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan_info")
public class LoanRequest {
	
	/*******************************************************************************************************************************
	   -Author                   :     Nagasri
	   -Created/Modified Date    :     20-08-2020
	   -Description              :     LoanRequest Bean Class
	 
	 ******************************************************************************************************************************/
	@Id
	private long loanRequestId;
	private double loanAmount;
	private String loanType;
	private int loanTenure;
	private double loanRoi;
	private String loanStatus;
	private double loanEmi;
	private int CreditScore;
	public LoanRequest() {
		super();
	}
	public long getLoanRequestId() {
		return loanRequestId;
	}
	public void setLoanRequestId(long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	public double getLoanRoi() {
		return loanRoi;
	}
	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public double getLoanEmi() {
		return loanEmi;
	}
	public void setLoanEmi(double loanEmi) {
		this.loanEmi = loanEmi;
	}
	public int getCreditScore() {
		return CreditScore;
	}
	public void setCreditScore(int creditScore) {
		CreditScore = creditScore;
	}
	public LoanRequest(long loanRequestId, double loanAmount, String loanType, int loanTenure, double loanRoi,
			String loanStatus, double loanEmi, int creditScore) {
		super();
		this.loanRequestId = loanRequestId;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.loanRoi = loanRoi;
		this.loanStatus = loanStatus;
		this.loanEmi = loanEmi;
		CreditScore = creditScore;
	}
	@Override
	public String toString() {
		return "LoanRequest [loanRequestId=" + loanRequestId + ", loanAmount=" + loanAmount + ", loanType=" + loanType
				+ ", loanTenure=" + loanTenure + ", loanRoi=" + loanRoi + ", loanStatus=" + loanStatus + ", loanEmi="
				+ loanEmi + ", CreditScore=" + CreditScore + "]";
	}
	
}