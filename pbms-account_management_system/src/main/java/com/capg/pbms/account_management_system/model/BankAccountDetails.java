package com.capg.pbms.account_management_system.model;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.OneToOne;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class BankAccountDetails {
	
	@Id
	private long accNumber;
	private String accountType;
	private double accountInterest;
	private double accountBalance;
	private String accountBranchId;
	private String customerName;
	private long customerPhno;
	private String accStatus;
	private long customerAdharId;
	private String customerPancard;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate customerDob;
	private String customerGender;
	@OneToOne(cascade= {CascadeType.ALL})
	private CustomerAddress customerAddress;
	 
	public BankAccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccountDetails(long accNumber, String accountType, double accountInterest, double accountBalance,
			String accountBranchId, String customerName, long customerPhno, String accStatus, long customerAdharId,
			String customerPancard, LocalDate customerDob, String customerGender, CustomerAddress customerAddress) {
		super();
		this.accNumber = accNumber;
		this.accountType = accountType;
		this.accountInterest = accountInterest;
		this.accountBalance = accountBalance;
		this.accountBranchId = accountBranchId;
		this.customerName = customerName;
		this.customerPhno = customerPhno;
		this.accStatus = accStatus;
		this.customerAdharId = customerAdharId;
		this.customerPancard = customerPancard;
		this.customerDob = customerDob;
		this.customerGender = customerGender;
		this.customerAddress = customerAddress;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountInterest() {
		return accountInterest;
	}
	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public long getCustomerAdharId() {
		return customerAdharId;
	}
	public void setCustomerAdharId(long customerAdharId) {
		this.customerAdharId = customerAdharId;
	}
	public String getCustomerPancard() {
		return customerPancard;
	}
	public void setCustomerPancard(String customerPancard) {
		this.customerPancard = customerPancard;
	}
	public LocalDate getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(LocalDate customerDob) {
		this.customerDob = customerDob;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	
	  public CustomerAddress getCustomerAddress() { return customerAddress; }
	  public void setCustomerAddress(CustomerAddress customerAddress) {
	  this.customerAddress = customerAddress;
	 
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public void setCustomerPhno(long customerPhno) {
		this.customerPhno = customerPhno;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getCustomerPhno() {
		return customerPhno;
	}
	public void setCustomerPhno(Long customerPhno) {
		this.customerPhno = customerPhno;
	}
	public Long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	
	}
	public String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	

}
