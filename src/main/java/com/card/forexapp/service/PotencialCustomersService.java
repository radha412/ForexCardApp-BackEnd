package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.PotencialCustomers;
import com.card.forexapp.repository.PotencialCustomerRepository;

@Service
public class PotencialCustomersService {
	
	@Autowired
	PotencialCustomerRepository potencialCustomerRepo;
	
	public List<PotencialCustomers> getAllPotencialCustomers() {
		return this.potencialCustomerRepo.findAll();
	}

}
