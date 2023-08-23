package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.service.ForexCardDetailsService;



@RestController
public class ForexCardDetailsController {
	
	@Autowired
	ForexCardDetailsService forexCardDetailService;
	
	@GetMapping("/forexcarddetails")
	public List<ForexCardDetails> getAllForexCardDetails(){
		return this.forexCardDetailService.getAllForexCardDetails();
	}

}
