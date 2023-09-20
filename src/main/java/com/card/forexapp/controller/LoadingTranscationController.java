package com.card.forexapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.exception.CurrentExchangeRateException;
import com.card.forexapp.service.CurrentExchangeRateService;
import com.card.forexapp.service.ForexCardService;
import com.card.forexapp.service.LoadingTranscationService;




@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class LoadingTranscationController {

	@Autowired
	//reference variable
	LoadingTranscationService loadingTranscationService;
		
	@Autowired
	CurrentExchangeRateService currentExchangeRateService;
	 
	@Autowired
	ForexCardService forexCardService;	
	
	
		
	@PostMapping("card/money/{forexcardnumber}/{basecountry}/{basecurrency}/{quotecountry}/{quotecurrency}/{loadingAmount}")
	public ResponseEntity<Double> addMoneyToForexCard(@PathVariable("forexcardnumber") Long forexcardNumber, 
			@PathVariable("loadingAmount") Double loadingAmount, 
			@PathVariable("basecountry") String baseCountry,
            @PathVariable("basecurrency") String baseCurrency ,
            @PathVariable("quotecountry") String quoteCountry ,
            @PathVariable("quotecurrency") String quoteCurrency) throws CurrentExchangeRateException {
		return ResponseEntity.ok(this.loadingTranscationService.addMoneyToForexCard(forexcardNumber, loadingAmount, baseCountry, baseCurrency, quoteCountry, quoteCurrency));
	}
	
	@PatchMapping("card/money/{forexcardnumber}/{unloadingAmount}/{basecountry}/{basecurrency}/{quotecountry}/{quotecurrency}")
	public ResponseEntity<Double> removeMoneyFromForexCard(@PathVariable("forexcardnumber") Long forexcardNumber, 
			@PathVariable("unloadingAmount") Double unloadingAmount, 
			@PathVariable("basecountry") String baseCountry,
            @PathVariable("basecurrency") String baseCurrency ,
            @PathVariable("quotecountry") String quoteCountry ,
            @PathVariable("quotecurrency") String quoteCurrency) throws CurrentExchangeRateException {
		return ResponseEntity.ok(this.loadingTranscationService.removeMoneyFromForexCard(forexcardNumber, unloadingAmount, baseCountry, baseCurrency, quoteCountry, quoteCurrency));
}
	

	
}
