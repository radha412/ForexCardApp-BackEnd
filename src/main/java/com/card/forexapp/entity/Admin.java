package com.card.forexapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	@Id
	private Integer adminId;
	
	private String adminEmail;
	private String Password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ForexCardDetails> forexCardDetails = new ArrayList<>();
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer adminId, String adminEmail, String password,
			List<com.card.forexapp.entity.ForexCardDetails> forexCardDetails) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		Password = password;
		this.forexCardDetails = forexCardDetails;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public List<ForexCardDetails> getForexCardDetails() {
		return forexCardDetails;
	}
	public void setForexCardDetails(List<ForexCardDetails> forexCardDetails) {
		this.forexCardDetails = forexCardDetails;
	}
	
	
}
