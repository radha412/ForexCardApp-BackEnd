package com.card.forexapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Email {
	@Id
	private Integer id;
	private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(Integer id, String recipient, String msgBody, String subject, String attachment) {
		super();
		this.id = id;
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
		this.attachment = attachment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject
				+ ", attachment=" + attachment + "]";
	}
    
    
    
    

}
