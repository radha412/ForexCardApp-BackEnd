package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.BankDetails;
import com.card.forexapp.service.BankDetailsService;

@RestController
public class BankDetailsController {

	@Autowired
	BankDetailsService bankDetailsService;
	
	@GetMapping("/bankDetails")
	public List<BankDetails> getAllBankDetails(){
		return this.bankDetailsService.getAllBankDetails();
	}
}
