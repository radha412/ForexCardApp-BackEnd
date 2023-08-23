package com.card.forexapp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PotencialCustomers {
	
	@Id
	private Long potencialCustomerId;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private LocalDateTime dateOfBirth;
	private Long adhaarNumber;
	private Long panCardNumber;
	private String occupation;
	private Long annualIncome;
	private String paymentMode;
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;
	private boolean status;
	public PotencialCustomers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PotencialCustomers(Long potencialCustomerId, String name, String email, String phoneNumber, String password,
			LocalDateTime dateOfBirth, Long adhaarNumber, Long panCardNumber, String occupation, Long annualIncome,
			String paymentMode, com.card.forexapp.entity.BankDetails bankDetails, boolean status) {
		super();
		this.potencialCustomerId = potencialCustomerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.adhaarNumber = adhaarNumber;
		this.panCardNumber = panCardNumber;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.paymentMode = paymentMode;
		this.bankDetails = bankDetails;
		this.status = status;
	}
	public Long getPotencialCustomerId() {
		return potencialCustomerId;
	}
	public void setPotencialCustomerId(Long potencialCustomerId) {
		this.potencialCustomerId = potencialCustomerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Long getAdhaarNumber() {
		return adhaarNumber;
	}
	public void setAdhaarNumber(Long adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}
	public Long getPanCardNumber() {
		return panCardNumber;
	}
	public void setPanCardNumber(Long panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Long getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	



}
