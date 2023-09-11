package com.card.forexapp.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String description;
    private String msgDescription;
    private LocalDateTime ComplainTime;
    private ComplaintPriority priority;
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(Long id, String customerName, String phoneNumber, String description, String msgDescription,
			LocalDateTime complainTime, ComplaintPriority priority) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.msgDescription = msgDescription;
		ComplainTime = complainTime;
		this.priority = priority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMsgDescription() {
		return msgDescription;
	}
	public void setMsgDescription(String msgDescription) {
		this.msgDescription = msgDescription;
	}
	public LocalDateTime getComplainTime() {
		return ComplainTime;
	}
	public LocalDateTime setComplainTime(LocalDateTime complainTime) {
		return ComplainTime = complainTime;
	}
	public ComplaintPriority getPriority() {
		return priority;
	}
	public void setPriority(ComplaintPriority priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Complaint [id=" + id + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber
				+ ", description=" + description + ", msgDescription=" + msgDescription + ", ComplainTime="
				+ ComplainTime + ", priority=" + priority + "]";
	}
	
    


}
