package com.card.forexapp.exception;

public class CurrentExchangeRateException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CurrentExchangeRateException(String msg) {
		super(msg+"Please provide valid countries and currencies . ");
		
	}

}
