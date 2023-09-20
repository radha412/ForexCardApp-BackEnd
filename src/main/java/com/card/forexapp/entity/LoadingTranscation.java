package com.card.forexapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class LoadingTranscation {
	@Id
	private Long paymentId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CurrentExchangeRate currentExchangeRate;
	@OneToOne(cascade = CascadeType.ALL)
	private ForexCard forexCard;
	private Double LoadingAmount;
	private LocalDateTime paymentDateTime;
	
	
	public LoadingTranscation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoadingTranscation(Long paymentId, CurrentExchangeRate currentExchangeRate, ForexCard forexCard,
			Double loadingAmount, LocalDateTime paymentDateTime) {
		super();
		this.paymentId = paymentId;
		this.currentExchangeRate = currentExchangeRate;
		this.forexCard = forexCard;
		LoadingAmount = loadingAmount;
		this.paymentDateTime = paymentDateTime;
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public CurrentExchangeRate getCurrentExchangeRate() {
		return currentExchangeRate;
	}


	public void setCurrentExchangeRate(CurrentExchangeRate currentExchangeRate) {
		this.currentExchangeRate = currentExchangeRate;
	}


	public ForexCard getForexCard() {
		return forexCard;
	}


	public void setForexCard(ForexCard forexCard) {
		this.forexCard = forexCard;
	}


	public Double getLoadingAmount() {
		return LoadingAmount;
	}


	public void setLoadingAmount(Double loadingAmount) {
		LoadingAmount = loadingAmount;
	}


	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}


	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
	

	
	

}
