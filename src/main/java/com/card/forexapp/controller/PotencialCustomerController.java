package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.PotencialCustomers;
import com.card.forexapp.service.PotencialCustomersService;



@RestController
public class PotencialCustomerController {
	
	@Autowired
	PotencialCustomersService potencialCustomerservice;
	
	@GetMapping("/potencialcustomers/")
	public List<PotencialCustomers> getAllForexCardDetails(){
		return this.potencialCustomerservice.getAllPotencialCustomers();
	}

}
