package com.card.forexapp.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PaymentTransaction {
	
	@Id
	private Long transactionId;
	
	private Long merchantAccountNumber;
	
	private LocalDateTime transactionDateTime;
	
	private Double amount;
	
	private Boolean paymentSatus;
	
	

	public PaymentTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentTransaction(Long transactionId, Long merchantAccountNumber,
			LocalDateTime transactionDateTime, Double amount, Boolean paymentSatus) {
		super();
		this.transactionId = transactionId;
		this.merchantAccountNumber = merchantAccountNumber;
		this.transactionDateTime = transactionDateTime;
		this.amount = amount;
		this.paymentSatus = paymentSatus;
	}
 
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getMerchantAccountNumber() {
		return merchantAccountNumber;
	}

	public void setMerchantAccountNumber(Long merchantAccountNumber) {
		this.merchantAccountNumber = merchantAccountNumber;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getPaymentSatus() {
		return paymentSatus;
	}

	public void setPaymentSatus(Boolean paymentSatus) {
		this.paymentSatus = paymentSatus;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId  + ", merchantAccountNumber="
				+ merchantAccountNumber + ", transactionDateTime=" + transactionDateTime + ", amount=" + amount
				+ ", paymentSatus=" + paymentSatus +"]";
	}
	
	
}
