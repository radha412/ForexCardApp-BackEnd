package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.card.forexapp.exception.PotentialCustomerException;
@RestControllerAdvice
public class PotentialCustomerAdvice {
	@ExceptionHandler(PotentialCustomerException.class)
	public ResponseEntity<String> handleEmailException(PotentialCustomerException potentialCustomerException){
		
		return new ResponseEntity<String>(potentialCustomerException.getMessage(), HttpStatus.BAD_REQUEST);	
	}
}