package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.Customer;
import com.card.forexapp.service.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers/")
	public List<Customer> getAllUser(){
		return customerService.getAllCustomers();
	}
}
