package com.card.forexapp.exception;

public class EmailVerificationException extends Exception{
	private static final long serialVersionUID = 1L;

	public EmailVerificationException(String msg){
		super();
		System.out.println("From Exception Class");
	}

}
