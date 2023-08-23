package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.CurrentExchangeRate;
import com.card.forexapp.repository.CurrentExchangeRateRepository;



@Service
public class CurrentExchangeRateService {
	
	@Autowired
	CurrentExchangeRateRepository currentExchangeRateRepository;
	
	public List<CurrentExchangeRate> getAllCurrentExchangeRate() {
		return this.currentExchangeRateRepository.findAll();	
	}
	
	

}