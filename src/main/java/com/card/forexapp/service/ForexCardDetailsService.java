package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.repository.ForexCardDetailsRepository;



@Service
public class ForexCardDetailsService {
	
	@Autowired
	ForexCardDetailsRepository forexCardDetailRepo;
	
	public List<ForexCardDetails> getAllForexCardDetails(){
		return this.forexCardDetailRepo.findAll();
	}

}
