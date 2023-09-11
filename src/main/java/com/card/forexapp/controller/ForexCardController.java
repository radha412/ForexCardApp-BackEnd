package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.service.ForexCardService;



@RestController
public class ForexCardController {
	
	@Autowired
	ForexCardService forexCardService;
	
	@GetMapping("/forexcard")
	public  List<ForexCard> getAllTranscation() {
		return this.forexCardService.getAllTranscation();
	}


}
