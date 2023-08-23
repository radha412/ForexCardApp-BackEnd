package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.PaymentTransaction;
import com.card.forexapp.service.PaymentTransactionService;



@RestController
public class PaymentTransactionController {
	
	@Autowired
	PaymentTransactionService paymentTransactionService ;
	
	@GetMapping("/transaction")
	public List<PaymentTransaction> getAllTransaction(){
		return this.paymentTransactionService.getAllTransaction();
	}
	

}
