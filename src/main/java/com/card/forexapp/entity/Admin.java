package com.card.forexapp.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	private String adminEmail;
	private String Password;
	private Boolean isSuperAdmin;
		public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Admin(Integer adminId, String adminEmail, String password, Boolean isAdmin
			) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		Password = password;

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

	public Boolean getIsAdmin() {
		return isSuperAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isSuperAdmin = isAdmin;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", Password=" + Password + ", isSuperAdmin="
				+ isSuperAdmin  + "]";
	}
	
	
}
