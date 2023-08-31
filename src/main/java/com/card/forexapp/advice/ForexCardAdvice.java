package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.ForexCardDetailsException;

@RestControllerAdvice
public class ForexCardAdvice {
	
	@ExceptionHandler(ForexCardDetailsException.class)

	public ResponseEntity<String> handleEmailException(ForexCardDetailsException forexCardDetailException){
	        return new ResponseEntity<String>(forexCardDetailException.getMessage(), HttpStatus.BAD_REQUEST);    

	    }

}
