package com.card.forexapp.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ForexCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ForexCardDetails forexCardDetails;
	
	private Long forexCardNumber;
	
	private String cardHolderName;
	
	private LocalDate expiryDate;
	
	private Integer cvv;
	
	private Integer pin;
	
	private Double limitBalance ;
	
	private Double currentBalance;
	
	private boolean isActivate;
	
	private Double manualSpendingLimit;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public ForexCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForexCard(Integer id, ForexCardDetails forexCardDetails, Long forexCardNumber, String cardHolderName,
			LocalDate expiryDate, Integer cvv, Integer pin, Double limitBalance, Double currentBalance,
			boolean isActivate, Double manualSpendingLimit, Customer customer) {
		super();
		this.id = id;
		this.forexCardDetails = forexCardDetails;
		this.forexCardNumber = forexCardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.pin = pin;
		this.limitBalance = limitBalance;
		this.currentBalance = currentBalance;
		this.isActivate = isActivate;
		this.manualSpendingLimit = manualSpendingLimit;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ForexCardDetails getForexCardDetails() {
		return forexCardDetails;
	}

	public void setForexCardDetails(ForexCardDetails forexCardDetails) {
		this.forexCardDetails = forexCardDetails;
	}

	public Long getForexCardNumber() {
		return forexCardNumber;
	}

	public void setForexCardNumber(Long forexCardNumber) {
		this.forexCardNumber = forexCardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Double getLimitBalance() {
		return limitBalance;
	}

	public void setLimitBalance(Double limitBalance) {
		this.limitBalance = limitBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public boolean isActivate() {
		return isActivate;
	}

	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}

	public Double getManualSpendingLimit() {
		return manualSpendingLimit;
	}

	public void setManualSpendingLimit(Double manualSpendingLimit) {
		this.manualSpendingLimit = manualSpendingLimit;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}