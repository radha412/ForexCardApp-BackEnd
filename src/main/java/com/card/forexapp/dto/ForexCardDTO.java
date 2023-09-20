package com.card.forexapp.dto;

import java.time.LocalDate;

public class ForexCardDTO {
	private Long forexCardNumber;
	private Integer cvv;
	private LocalDate expiryDate;
	private Integer pin;
	
	public ForexCardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ForexCardDTO(Long forexCardNumber, Integer cvv, LocalDate expiryDate) {
		super();
		this.forexCardNumber = forexCardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	public Long getForexCardNumber() {
		return forexCardNumber;
	}

	public void setForexCardNumber(Long forexCardNumber) {
		this.forexCardNumber = forexCardNumber;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getPin() {
		return this.pin;
	}
	
	public void setPin(Integer pin) {
		this.pin = pin;
	}
}
