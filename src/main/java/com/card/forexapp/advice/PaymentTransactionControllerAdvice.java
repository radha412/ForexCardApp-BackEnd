package com.card.forexapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.card.forexapp.exception.PaymentTransactionException;


 

@RestControllerAdvice
public class PaymentTransactionControllerAdvice {
	 @ExceptionHandler(PaymentTransactionException.class)
	   public ResponseEntity<String> handleProductException(PaymentTransactionException paymentTransactionException){
	       return new ResponseEntity<>(paymentTransactionException.getMessage(),HttpStatus.BAD_REQUEST);
	   }

 

}
