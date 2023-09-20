package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.LoadingTransactionException;

@RestControllerAdvice
public class LoadingTransactionAdvice {
	@ExceptionHandler(LoadingTransactionException.class)

    public ResponseEntity<String> handleEmailException(LoadingTransactionException loadingTransactionException){
            return new ResponseEntity<String>(loadingTransactionException.getMessage(), HttpStatus.BAD_REQUEST);    

        }

}