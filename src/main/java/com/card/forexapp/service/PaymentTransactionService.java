package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.PaymentTransaction;
import com.card.forexapp.repository.PaymentTransactionRepository;



@Service
public class PaymentTransactionService {
	
	@Autowired
	 PaymentTransactionRepository  transactionRepo;
	
	public List<PaymentTransaction> getAllTransaction(){
		return this.transactionRepo.findAll();
	}

}
