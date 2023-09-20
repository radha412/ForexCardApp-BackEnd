package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.EmailVerificationException;



@RestControllerAdvice
public class EmailVerificationAdvice {
	@ExceptionHandler(EmailVerificationException.class)
	public ResponseEntity<String> handleEmailException(EmailVerificationException emailVerificationException){
		
		return new ResponseEntity<String>(emailVerificationException.getMessage(), HttpStatus.BAD_REQUEST);	
	}
}
