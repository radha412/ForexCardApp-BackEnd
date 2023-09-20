package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.CurrentExchangeRate;

public interface CurrentExchangeRateRepository extends JpaRepository<CurrentExchangeRate, Integer> {
	
	CurrentExchangeRate findByQuoteCurrencyAndBaseCurrency(String quoteCurrency, String baseCurrency);


}
