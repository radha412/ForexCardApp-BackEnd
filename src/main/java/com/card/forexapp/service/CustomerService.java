package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Customer;
import com.card.forexapp.repository.CustomerRepository;



@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
