package com.card.forexapp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PotentialCustomers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long potentialCustomerId;
	private String name;
	
	@Column(unique = true)
	private String email;
	private String phoneNumber;
	private String password;
	private LocalDateTime dateOfBirth;
	private Long adhaarNumber;
	private String panCardNumber;
	private String occupation;
	private Long annualIncome;
	private String paymentMode;
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;
	private boolean status;
	
	public PotentialCustomers() {
		super();
	}
	
	
	public PotentialCustomers(Long potentialCustomerId, String name, String email, String phoneNumber, String password,
			LocalDateTime dateOfBirth, Long adhaarNumber, String panCardNumber, String occupation, Long annualIncome,
			String paymentMode, BankDetails bankDetails, boolean status) {
		super();
		this.potentialCustomerId = potentialCustomerId;
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


	public Long getPotentialCustomerId() {
		return potentialCustomerId;
	}
	public void setPotencialCustomerId(Long potentialCustomerId) {
		this.potentialCustomerId = potentialCustomerId;
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
	
	public String getPanCardNumber() {
		return panCardNumber;
	}


	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}


	public void setPotentialCustomerId(Long potentialCustomerId) {
		this.potentialCustomerId = potentialCustomerId;
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
