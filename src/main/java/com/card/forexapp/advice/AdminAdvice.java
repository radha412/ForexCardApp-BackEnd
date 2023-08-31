package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.AdminException;

@RestControllerAdvice
public class AdminAdvice {

	@ExceptionHandler(AdminException.class)

	public ResponseEntity<String> handleEmailException(AdminException adminException){
	        return new ResponseEntity<String>(adminException.getMessage(), HttpStatus.BAD_REQUEST);    

	    }
}
