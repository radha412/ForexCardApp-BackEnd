package com.card.forexapp.entity; 

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 

@Entity
public class PaymentTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private String merchant;
	private LocalDateTime transactionDateTime;
	private Double amount;
	private String currency;
	private String paymentMethod;
	private String paymentStatus;

 

	public PaymentTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

 

	public PaymentTransaction(Long transactionId, String merchant, LocalDateTime transactionDateTime, Double amount,
			String paymentStatus, String currency, String paymentMethod) {
		super();
		this.transactionId = transactionId;
		this.merchant = merchant;
		this.transactionDateTime = transactionDateTime;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.currency = currency;
		this.paymentMethod = paymentMethod;
	}

 

	public Long getTransactionId() {
		return transactionId;
	}

 

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

 

	public String getMerchant() {
		return merchant;
	}

 

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

 

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

 

	public LocalDateTime setTransactionDateTime(LocalDateTime transactionDateTime) {
		return this.transactionDateTime = transactionDateTime;
	}

 

	public Double getAmount() {
		return amount;
	}

 

	public void setAmount(Double amount) {
		this.amount = amount;
	}

 

	public String getPaymentStatus() {
		return paymentStatus;
	}

 

	public String setPaymentStatus(String paymentStatus) {
		return this.paymentStatus = paymentStatus;
	}

 

	public String getCurrency() {
		return currency;
	}

 

	public void setCurrency(String currency) {
		this.currency = currency;
	}

 

	public String getPaymentMethod() {
		return paymentMethod;
	}

 

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

 

	@Override
	public String toString() {
		return "PaymentTransaction [transactionId=" + transactionId + ", merchant=" + merchant
				+ ", transactionDateTime=" + transactionDateTime + ", amount=" + amount + ", paymentStatus="
				+ paymentStatus + ", currency=" + currency + ", paymentMethod=" + paymentMethod + "]";
	}

 

	
}
