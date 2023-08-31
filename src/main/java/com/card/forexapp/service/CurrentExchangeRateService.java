package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.CurrentExchangeRate;
import com.card.forexapp.exception.CurrentExchangeRateException;
import com.card.forexapp.repository.CurrentExchangeRateRepository;


import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;


@Service
public class CurrentExchangeRateService {
	
	@Autowired
	CurrentExchangeRateRepository currentExchangeRateRepository;
	
	public List<CurrentExchangeRate> getAllCurrentExchangeRate() {
		return this.currentExchangeRateRepository.findAll();	
	}

	public Double createExchangeRate(String basecurrency , String basecountry ,
									String quotecurrency , String quotecountry) throws CurrentExchangeRateException {
		CurrentExchangeRate currentExchangeRate = new CurrentExchangeRate();
		LocalDateTime now = LocalDateTime.now();
		currentExchangeRate.setTime(now);
		currentExchangeRate.setBaseCountry(basecountry);
		currentExchangeRate.setQuoteCountry(quotecountry);
		currentExchangeRate.setBaseCurrency(basecurrency);
		currentExchangeRate.setQuoteCurrency(quotecurrency);
		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://api.exchangerate.host/latest"))
				.uri(URI.create("https://api.currencyapi.com/v3/latest?apikey=cur_live_A056HgHK2W7OKT47oNACjCuGhXKhnVw8bqc0xacc&currencies="+quotecurrency+"&base_currency="+basecurrency))
				.header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
				.header("X-RapidAPI-Key", "your-rapidapi-key")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String[] rates = response.body().split(",");
			String rate = (String) rates[2].subSequence(8, 13);
			currentExchangeRate.setExchangeRate(Double.parseDouble(rate));
			this.currentExchangeRateRepository.save(currentExchangeRate);
			System.out.println(currentExchangeRate.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentExchangeRate.getExchangeRate();
		
	}
	
	

}