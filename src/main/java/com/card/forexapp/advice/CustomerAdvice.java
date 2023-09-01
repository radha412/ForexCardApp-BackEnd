package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.CustomerException;



@RestControllerAdvice
public class CustomerAdvice {
	
	@ExceptionHandler(CustomerException.class)

	public ResponseEntity<String> handleEmailException(CustomerException customerException){
	        return new ResponseEntity<String>(customerException.getMessage(), HttpStatus.BAD_REQUEST);    

	    }

}
