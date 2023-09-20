package com.card.forexapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class OrderRequest {

	@Id
	Integer id;

	String customerName;

	String email;

	String phoneNumber;

	Double amount;

	public OrderRequest() {

		super();

	}

	public OrderRequest(Integer id, String customerName, String email, String phoneNumber, Double amount) {

		super();

		this.id = id;

		this.customerName = customerName;

		this.email = email;

		this.phoneNumber = phoneNumber;

		this.amount = amount;

	}

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getCustomerName() {

		return customerName;

	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPhoneNumber() {

		return phoneNumber;

	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;

	}

	public Double getAmount() {

		return amount;

	}

	public void setAmount(Double amount) {

		this.amount = amount;

	}

	@Override

	public String toString() {

		return "OrderRequest [id=" + id + ", customerName=" + customerName + ", email=" + email + ", phoneNumber="

				+ phoneNumber + ", amount=" + amount + "]";

	}
}
