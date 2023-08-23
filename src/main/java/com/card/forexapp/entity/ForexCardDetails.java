package com.card.forexapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ForexCardDetails {
	
	@Id
	private Integer forexCardNameId ;	
	private String forexCardName;
	private String forexCardConversionFee;
	private Double maxSpendingLimit;
	private Double platformfee;
	private Double subscriptionFees;
	private Double baseIncome;
	//private string features
	public ForexCardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ForexCardDetails(Integer forexCardNameId, String forexCardName, String forexCardConversionFee,
			Double maxSpendingLimit, Double platformfee, Double subscriptionFees, Double baseIncome) {
		super();
		this.forexCardNameId = forexCardNameId;
		this.forexCardName = forexCardName;
		this.forexCardConversionFee = forexCardConversionFee;
		this.maxSpendingLimit = maxSpendingLimit;
		this.platformfee = platformfee;
		this.subscriptionFees = subscriptionFees;
		this.baseIncome = baseIncome;
	}


	public Integer getForexCardNameId() {
		return forexCardNameId;
	}
	public void setForexCardNameId(Integer forexCardNameId) {
		this.forexCardNameId = forexCardNameId;
	}
	public String getForexCardName() {
		return forexCardName;
	}
	public void setForexCardName(String forexCardName) {
		this.forexCardName = forexCardName;
	}
	public String getForexCardConversionFee() {
		return forexCardConversionFee;
	}
	public void setForexCardConversionFee(String forexCardConversionFee) {
		this.forexCardConversionFee = forexCardConversionFee;
	}
	public Double getMaxSpendingLimit() {
		return maxSpendingLimit;
	}
	public void setMaxSpendingLimit(Double maxSpendingLimit) {
		this.maxSpendingLimit = maxSpendingLimit;
	}
	public Double getPlatformfee() {
		return platformfee;
	}
	public void setPlatformfee(Double platformfee) {
		this.platformfee = platformfee;
	}


	public Double getSubscriptionFees() {
		return subscriptionFees;
	}


	public void setSubscriptionFees(Double subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
	}


	public Double getBaseIncome() {
		return baseIncome;
	}


	public void setBaseIncome(Double baseIncome) {
		this.baseIncome = baseIncome;
	}
	
	
	
	

}
