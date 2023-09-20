package com.card.forexapp.entity;


 

import java.util.ArrayList;

import java.util.List;

 

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.OneToOne;

 

@Entity

public class Customer {


	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long customerId;

	private String phoneNumber;



	private String email;

	private String password;

	private String resetPasswordToken;


	private String adhaarCardNumber;

	private String panCardNumber;

	private String passportNumber;


	public String getAdhaarCardNumber() {

		return adhaarCardNumber;

	}

 

	public void setAdhaarCardNumber(String adhaarCardNumber) {

		this.adhaarCardNumber = adhaarCardNumber;

	}

 

	public String getPanCardNumber() {

		return panCardNumber;

	}

 

	public void setPanCardNumber(String panCardNumber) {

		this.panCardNumber = panCardNumber;

	}

 

	public String getPassportNumber() {

		return passportNumber;

	}

 

 

	public void setPassportNumber(String passportNumber) {

		this.passportNumber = passportNumber;

	}

 

	@OneToMany(cascade = CascadeType.ALL)

	private List<LoadingTranscation> loadingTranscations=new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)

	private List<PaymentTransaction> paymentTranscations =  new ArrayList<>();


	@OneToOne(cascade = CascadeType.ALL)

	private ForexCard forexCard;

 

	public Customer() {

		super();

		// TODO Auto-generated constructor stub

	}

 

 

	

 

	public Customer(Long customerId, String phoneNumber, String email, String password, String resetPasswordToken,

			List<LoadingTranscation> loadingTranscations, List<PaymentTransaction> paymentTranscations,

			ForexCard forexCard) {

		super();

		this.customerId = customerId;

		this.phoneNumber = phoneNumber;

		this.email = email;

		this.password = password;

		this.resetPasswordToken = resetPasswordToken;

		this.loadingTranscations = loadingTranscations;

		this.paymentTranscations = paymentTranscations;

		this.forexCard = forexCard;

	}

 

 

 

	public String getPhoneNumber() {

		return phoneNumber;

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

 

 

 

	public Long getCustomerId() {

		return customerId;

	}

 

	public void setCustomerId(Long customerId) {

		this.customerId = customerId;

	}

 

	public List<LoadingTranscation> getLoadingTranscations() {

		return loadingTranscations;

	}

 

	public void setLoadingTranscations(List<LoadingTranscation> loadingTranscations) {

		this.loadingTranscations = loadingTranscations;

	}

 

	public List<PaymentTransaction> getPaymentTranscations() {

		return paymentTranscations;

	}

 

	public void setPaymentTranscations(List<PaymentTransaction> paymentTranscations) {

		this.paymentTranscations = paymentTranscations;

	}

 

	public ForexCard getForexCard() {

		return forexCard;

	}

 

	public void setForexCard(ForexCard forexCard) {

		this.forexCard = forexCard;

	}

 

 

	public String getPassword() {

		return password;

	}

 

	public void setPassword(String password) {

		this.password = password;

	}

 

	public String getResetPasswordToken() {

		return resetPasswordToken;

	}

 

	public void setResetPasswordToken(String resetPasswordToken) {

		this.resetPasswordToken = resetPasswordToken;

	}




 

}
