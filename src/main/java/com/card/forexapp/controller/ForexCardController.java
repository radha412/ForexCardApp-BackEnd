package com.card.forexapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.card.forexapp.dto.ForexCardDTO;
import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.exception.ForexCardException;
import com.card.forexapp.service.ForexCardService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ForexCardController {
	
	@Autowired
	ForexCardService forexCardService;
	
	@GetMapping("/forexcard")
	public  List<ForexCard> getAllTranscation() {
		return this.forexCardService.getAllTranscation();
	}

//	@GetMapping("forex-card/generate")
//	public ForexCardDTO generateForexCardNumber() {
// 	return this.forexCardService.generateForexCardDetails();
//	}
	
	@PatchMapping("forex-card/set-pin/")
	public void setForexCardPin(@RequestBody ForexCardDTO forexCardDto) throws ForexCardException {
		this.forexCardService.setForexCardPin(forexCardDto);
	}
	
	@PatchMapping("forex-card/update-pin")
	public void updateForexCardPin(@RequestBody ForexCardDTO forexCardDto) throws ForexCardException{
		//we need the forex card, the cvv, the expiry date
		this.forexCardService.updateForexCardPin(forexCardDto);
	}
}
