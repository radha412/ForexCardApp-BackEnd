package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.PaymentTransaction;
import com.card.forexapp.exception.CustomerException;
import com.card.forexapp.exception.PaymentTransactionException;
import com.card.forexapp.service.PaymentTransactionService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentTransactionController {
	
	@Autowired
	PaymentTransactionService paymentService ;
	
	@GetMapping("/transaction")
	public List<PaymentTransaction> getAllTransaction(){
		return this.paymentService.getAllTransaction();
	}
	
	 @PostMapping("/customer/withdrawal/{forexcardnumber}/{pin}")
	 public Boolean withdrawMoney(@PathVariable("forexcardnumber")Long forexCardNumber,
			 @PathVariable("pin")Integer pin,
			 @RequestBody PaymentTransaction paymentTransaction)throws PaymentTransactionException, CustomerException{

		return this.paymentService.withdrawFromForexCard(forexCardNumber,pin, paymentTransaction);
	 }

	 @PostMapping("customer/transaction/{deposit-amount}/{id}")
	public Boolean depositMoney(@PathVariable("id")Long customerId,
			@PathVariable("deposit-amount") Double depositAmount,
			@RequestBody PaymentTransaction paymentTransaction) 
					throws PaymentTransactionException, CustomerException {
		return this.paymentService.depositToForexCard(customerId,depositAmount,paymentTransaction);
	 }
	

}
