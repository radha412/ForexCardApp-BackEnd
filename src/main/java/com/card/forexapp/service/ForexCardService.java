package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.repository.ForexCardRepository;



@Service
public class ForexCardService {
	
	@Autowired
	ForexCardRepository forexCardRepo;

	public  List<ForexCard> getAllTranscation() {
		return this.forexCardRepo.findAll();
		
	}
	
	

}
