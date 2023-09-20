package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.CurrentExchangeRate;
import com.card.forexapp.exception.CurrentExchangeRateException;
import com.card.forexapp.service.CurrentExchangeRateService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CurrentExchangeRateController {
	
	@Autowired
	CurrentExchangeRateService currentExchangeRateService;
	
	@PostMapping("/currencyrate/{basecountry}/{basecurrency}/{quotecountry}/{quotecurrency}")
	public ResponseEntity<Double> createExchangeRate(	@PathVariable("basecountry") String basecountry,
									@PathVariable("basecurrency") String basecurrency ,
									@PathVariable("quotecountry") String quotecountry ,
									@PathVariable("quotecurrency") String quotecurrency) {
			Double rate = null;
			try {
				rate = this.currentExchangeRateService.createExchangeRate(basecurrency ,basecountry ,quotecurrency , quotecurrency);
			} 
			catch(NumberFormatException e){
				e.printStackTrace();
			}
			catch (CurrentExchangeRateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResponseEntity.ok(rate);	
	}

	@GetMapping("/currencyrate")
	public List<CurrentExchangeRate> getAllExchangeRate() throws CurrentExchangeRateException{
		return this.currentExchangeRateService.getAllCurrentExchangeRate();
	}
	
	

}