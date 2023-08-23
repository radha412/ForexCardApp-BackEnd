package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.BankDetails;
import com.card.forexapp.repository.BankDetailsRepository;



@Service
public class BankDetailsService {
	
	@Autowired
	BankDetailsRepository bankDetailsRepo;

	public List<BankDetails> getAllBankDetails() {
		// TODO Auto-generated method stub
		return this.bankDetailsRepo.findAll();
	}

}
