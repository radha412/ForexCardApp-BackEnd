package com.card.forexapp.dto;

public class OTPDto {
	private String customerEmail;
	private Integer otp;
	
	public OTPDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OTPDto(String customerEmail, Integer otp) {
		super();
		this.customerEmail = customerEmail;
		this.otp = otp;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}
}
