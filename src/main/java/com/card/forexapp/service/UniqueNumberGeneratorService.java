package com.card.forexapp.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UniqueNumberGeneratorService {
	public Long uniqueForexNumberGenerator() {
		Long timestamp = System.currentTimeMillis();
		Integer randomPart = (int) (Math.random() * 100);
		String uniqueNumber = String.valueOf(timestamp) + String.format("%o3", randomPart);
		return Long.parseLong(uniqueNumber);
	}
	
	public LocalDate generateExpriryDate() {
		Integer minyear = 2024;
		Integer maxyear = 2030;
		Random random = new Random();
		Integer randomYear = random.nextInt(maxyear - minyear+1) + minyear;
		Integer randomMonth = random.nextInt(12)+1;
		Integer maxday = LocalDate.of(randomYear, randomMonth, 1).lengthOfMonth();
		Integer randomDay = random.nextInt(maxday)+1;
		LocalDate randomExpiryDate = LocalDate.of(randomYear, randomMonth, randomDay);
		return randomExpiryDate;
	}
	
	public Integer generateniqueCvv() {
		Random random = new Random();
		Integer cvv = random.nextInt(900) + 100;
		return cvv;
	}
}
