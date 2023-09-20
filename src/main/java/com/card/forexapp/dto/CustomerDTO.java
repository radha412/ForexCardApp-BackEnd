package com.card.forexapp.dto;

 

public class CustomerDTO {

	private Long customerId;

	private String phoneNumber;

	private String name;

	

	private String email;

	private String adhaarNumber;

	private String pancard;

	private String passport;

	public String getPhoneNumber() {

		return phoneNumber;}

	public String getName() {

		return name;

	}

 

	public void setName(String name) {

		this.name = name;

	}

 

 

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

 

	public String getEmail() {

		return email;

	}

 

	public void setEmail(String email) {

		this.email = email;

	}

 

	public String getAdhaarNumber() {

		return adhaarNumber;

	}

 

	public void setAdhaarNumber(String adhaarNumber) {

		this.adhaarNumber = adhaarNumber;

	}

 

	public String getPancard() {

		return pancard;

	}

 

	public void setPancard(String pancard) {

		this.pancard = pancard;

	}

 

	public String getPassport() {

		return passport;

	}

 

	public void setPassport(String passport) {

		this.passport = passport;

	}

 

	CustomerDTO(){

		

	}

	

	CustomerDTO(Long customerId){

		this.customerId = customerId;

	}

 

	public Long getCustomerId() {

		return customerId;

	}

 

	public void setCustomerId(Long customerId) {

		this.customerId = customerId;

	}

}