package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.CurrentExchangeRate;
import com.card.forexapp.service.CurrentExchangeRateService;



@RestController
public class CurrentExchangeRateController {
	
	@Autowired
	CurrentExchangeRateService currentExchangeRateService;
	
	@GetMapping("/currency")
	public List<CurrentExchangeRate> getAllCurrentExchangeRate() {
		return this.currentExchangeRateService.getAllCurrentExchangeRate();
	}
	
	
	
	
	

}