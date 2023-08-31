package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.CurrentExchangeRateException;



@RestControllerAdvice
public class CurrentExchangeRateAdvice {
	
	@ExceptionHandler(CurrentExchangeRateException.class)

	public ResponseEntity<String> handleEmailException(CurrentExchangeRateException exchangeRateException){
	        return new ResponseEntity<String>(exchangeRateException.getMessage(), HttpStatus.BAD_REQUEST);    

	    }

}
