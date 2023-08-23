package com.card.forexapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentExchangeRate {
	@Id
	private Integer id;
	
	private String quoteCurrency;
	
	private String quoteCountry;
	
	private String baseCurrency;
	
	private String baseCountry;
	
	private LocalDateTime time;
	
	private Double exchangeRate;

	public CurrentExchangeRate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentExchangeRate(Integer id, String quoteCurrency, String quoteCountry, String baseCurrency,
			String baseCountry, LocalDateTime time, Double exchangeRate) {
		super();
		this.id = id;
		this.quoteCurrency = quoteCurrency;
		this.quoteCountry = quoteCountry;
		this.baseCurrency = baseCurrency;
		this.baseCountry = baseCountry;
		this.time = time;
		this.exchangeRate = exchangeRate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public String getQuoteCountry() {
		return quoteCountry;
	}

	public void setQuoteCountry(String quoteCountry) {
		this.quoteCountry = quoteCountry;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getBaseCountry() {
		return baseCountry;
	}

	public void setBaseCountry(String baseCountry) {
		this.baseCountry = baseCountry;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}

