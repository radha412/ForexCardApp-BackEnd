package com.card.forexapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusinessProfit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double loadingProfit ;
	private Double paymentTranscationsProfit;
	public BusinessProfit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessProfit(Integer id, Double loadingProfit, Double paymentTranscationsProfit) {
		super();
		this.id = id;
		this.loadingProfit = loadingProfit;
		this.paymentTranscationsProfit = paymentTranscationsProfit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLoadingProfit() {
		return loadingProfit;
	}
	public void setLoadingProfit(Double loadingProfit) {
		this.loadingProfit = loadingProfit;
	}
	public Double getPaymentTranscationsProfit() {
		return paymentTranscationsProfit;
	}
	public void setPaymentTranscationsProfit(Double paymentTranscationsProfit) {
		this.paymentTranscationsProfit = paymentTranscationsProfit;
	}
	@Override
	public String toString() {
		return "BusinessProfit [id=" + id + ", loadingProfit=" + loadingProfit + ", paymentTranscationsProfit="
				+ paymentTranscationsProfit + "]";
	}
	
	

}
