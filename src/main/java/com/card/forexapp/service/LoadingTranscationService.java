package com.card.forexapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.exception.CurrentExchangeRateException;
import com.card.forexapp.repository.LoadingTranscationRepository;

@Service
public class LoadingTranscationService {
//	@Autowired
//	ForexCard forexCard;

	@Autowired
	CurrentExchangeRateService currentExchangeRateService;

	@Autowired
	LoadingTranscationRepository loadingTransactionRepo;

	@Autowired
	ForexCardService forexCardService;


	public Double addMoneyToForexCard(Long forexcardNumber, Double loadingAmount, String baseCountry,
			String baseCurrency, String quoteCountry, String quoteCurrency) throws CurrentExchangeRateException {
     
		ForexCard forexCard = this.forexCardService.getForexCardByNumber(forexcardNumber);
		if (forexCard == null) {
			System.out.println("FOREX CARD : " + forexCard);
		}
		Double exchangeRate = null;
		try {
			exchangeRate = this.currentExchangeRateService.createExchangeRate(baseCurrency, baseCountry, quoteCurrency,
					quoteCurrency);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		double convertedAmount = exchangeRate * loadingAmount;
		Double currentBalance = null;
		currentBalance = forexCard.getCurrentBalance();
		forexCard.setCurrentBalance(currentBalance + convertedAmount);
		this.forexCardService.createForexCard(forexCard);
		return forexCard.getCurrentBalance();
	}

	public Double removeMoneyFromForexCard(Long forexcardNumber, Double unloadingAmount, String baseCountry,
			String baseCurrency, String quoteCountry, String quoteCurrency) throws CurrentExchangeRateException {

		ForexCard forexCard = this.forexCardService.getForexCardByNumber(forexcardNumber);
		
		if (forexCard == null) {
			throw new CurrentExchangeRateException("ForexCardNumber Not available");
		}
		Double exchangeRate = null;
		try {
			exchangeRate = this.currentExchangeRateService.createExchangeRate(baseCurrency, baseCountry, quoteCurrency,
					quoteCurrency);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		double convertedAmount = exchangeRate * unloadingAmount;

		Double currentBalance = forexCard.getCurrentBalance();
		currentBalance = forexCard.getCurrentBalance();
		forexCard.setCurrentBalance(currentBalance - convertedAmount);
		this.forexCardService.createForexCard(forexCard);
		return forexCard.getCurrentBalance();
	}

}
