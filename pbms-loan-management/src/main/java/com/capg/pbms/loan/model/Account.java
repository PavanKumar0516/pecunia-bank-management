package com.capg.pbms.loan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_info")
public class Account {
	

/*******************************************************************************************************************************
	   -Author                   :     Nagasri
	   -Created/Modified Date    :     20-08-2020
	   -Description              :     AccountDetails Bean Class
	 
	 ******************************************************************************************************************************/
	
	@Id
	//@Pattern(regexp="[0-9]{12}")
	private long accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private double accountIntrest;
	public Account() {
		super();
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getAccountIntrest() {
		return accountIntrest;
	}
	public void setAccountIntrest(double accountIntrest) {
		this.accountIntrest = accountIntrest;
	}
	public Account( long accountId, String accountHolderId, String accountBranchId,
			String accountType, String accountStatus, double accountBalance, double accountIntrest) {
		super();
		this.accountId = accountId;
		this.accountHolderId = accountHolderId;
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.accountIntrest = accountIntrest;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolderId=" + accountHolderId + ", accountBranchId="
				+ accountBranchId + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountBalance=" + accountBalance + ", accountIntrest=" + accountIntrest + "]";
	}
	
}