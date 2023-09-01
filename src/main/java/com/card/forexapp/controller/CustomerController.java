package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.Customer;
import com.card.forexapp.service.CustomerService;
import com.card.forexapp.service.EmailService;



@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/customers/")
	public List<Customer> getAllUser(){
		return customerService.getAllCustomers();
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createNewCustomer(Customer customer){
		this.emailService.sendMessagePeriodically(customer.getCustomerEmail());
		this.customerService.createNewCustomer(customer);
		return ResponseEntity.ok(customer);
		
	}
}
