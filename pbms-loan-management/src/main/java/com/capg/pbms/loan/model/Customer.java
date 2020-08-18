package com.capg.pbms.loan.model;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Cus_info")
public class Customer {
	@Id
	@Column(name = "accountId")
	private  long  accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private double accountIntrest;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate lastUpdated;
	private String customerId;
	private String customerName;
	private String customerAadhar;
	private String customerPan;
	private String customerContact;
	private String customerGender;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate customerDob;
	
	@OneToOne
	private Address customerAddress;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomerPan() {
		return customerPan;
	}

	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public LocalDate getCustomerDob() {
		
		return customerDob;
	}

	public void setCustomerDob(LocalDate customerDob) {
		this.customerDob = customerDob;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	
	public Customer(long accountId, String accountHolderId, String accountBranchId, String accountType,
			String accountStatus, double accountBalance, double accountIntrest, LocalDate lastUpdated,
			String customerId, String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, LocalDate customerDob, Address customerAddress) {
		super();
		this.accountId = accountId;
		this.accountHolderId = accountHolderId;
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.accountIntrest = accountIntrest;
		this.lastUpdated = lastUpdated;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAadhar = customerAadhar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [accountId=" + accountId + ", accountHolderId=" + accountHolderId + ", accountBranchId="
				+ accountBranchId + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountBalance=" + accountBalance + ", accountIntrest=" + accountIntrest + ", lastUpdated="
				+ lastUpdated + ", customerId=" + customerId + ", customerName=" + customerName + ", customerAadhar="
				+ customerAadhar + ", customerPan=" + customerPan + ", customerContact=" + customerContact
				+ ", customerGender=" + customerGender + ", customerDob=" + customerDob + ", customerAddress="
				+ customerAddress + "]";
	}

	 	
 }