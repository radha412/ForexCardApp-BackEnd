package com.card.forexapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BankDetails")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	private String accountHolderName;
	private String bankName;
	private String IFSCCode;
	private String branchName;
	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankDetails(Long accountNumber, String accountHolderName, String bankName, String iFSCCode,
			String branchName) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		IFSCCode = iFSCCode;
		this.branchName = branchName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", bankName=" + bankName + ", IFSCCode=" + IFSCCode + ", branchName=" + branchName + "]";
	}
	
	

}

