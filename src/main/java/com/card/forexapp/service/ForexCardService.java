package com.card.forexapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.dto.ForexCardDTO;
import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.exception.ForexCardException;
import com.card.forexapp.repository.ForexCardDetailsRepository;
import com.card.forexapp.repository.ForexCardRepository;



@Service
public class ForexCardService {
	
	@Autowired
	ForexCardRepository forexCardRepo;
	
	@Autowired
	ForexCardDetailsRepository forexCardDetailRepo;
	
	@Autowired
	private UniqueNumberGeneratorService uniqueNumberGeneratorService;

	public  List<ForexCard> getAllTranscation() {
		// TODO Auto-generated method stub
		return this.forexCardRepo.findAll();
		
	}
	

	public ForexCard getForexCardByNumber(Long forexCardNumber) {
		return this.forexCardRepo.findByForexCardNumber(forexCardNumber).get();
	}


	public void createForexCard(ForexCard forexCard) {
		this.forexCardRepo.save(forexCard);
		
	}
	public ForexCard updateForexCard(ForexCard forexCard) {

		return this.forexCardRepo.save(forexCard);

	}
	
	public ForexCard verifyForexCard(ForexCardDTO forexCardDto) throws ForexCardException {
		Optional<ForexCard> forexCardOpt = this.forexCardRepo.findByForexCardNumber(forexCardDto.getForexCardNumber());
		if (forexCardOpt.isEmpty()) {
			throw new ForexCardException("You have entered a wrong forex card number");
		}
		ForexCard forexcard = forexCardOpt.get();
		if (forexcard.getForexCardNumber() != forexCardDto.getForexCardNumber()
				|| forexcard.getCvv() != forexcard.getCvv()
				|| forexcard.getExpiryDate().equals(forexcard.getExpiryDate())) {
			throw new ForexCardException("Please check out the forex card details");
		}
		return forexcard;
	}
	
	public ForexCardDTO generateForexCardDetails() {
		Long uniqueForexNumber = this.uniqueNumberGeneratorService.uniqueForexNumberGenerator();
		LocalDate randomExpiryDate = this.uniqueNumberGeneratorService.generateExpriryDate();
		Integer cvv = this.uniqueNumberGeneratorService.generateniqueCvv();
		ForexCardDTO forexCardDTO = new ForexCardDTO(uniqueForexNumber, cvv, randomExpiryDate);
		return forexCardDTO;
	}

	public void setForexCardPin(ForexCardDTO forexCardDto) throws ForexCardException {
		ForexCard forexCard = this.verifyForexCard(forexCardDto);
		forexCard.setPin(forexCardDto.getPin());
		forexCard.setActivate(true);
	}

	public void updateForexCardPin(ForexCardDTO forexCardDto) throws ForexCardException {
		ForexCard forexcard = this.verifyForexCard(forexCardDto);
		
		 if (forexcard.getPin() != forexCardDto.getPin()) {
			throw new ForexCardException("You have entered a wrong pin");
		}
		forexcard.setPin(forexCardDto.getPin());
		
		if(forexcard.getCustomer().getEmail() != null) {
			System.out.println("We will send an email ");
		}
		
		if(forexcard.getCustomer().getPhoneNumber() != null) {
			System.out.println("We will send an sms ");
		}
	}


	public ForexCardDetails getForexCardByNumber(int i) {
		// TODO Auto-generated method stub
		Optional<ForexCardDetails> forexCardDetailOpt=this.forexCardDetailRepo.findById(i);
		return forexCardDetailOpt.get();
		
	}

	

}
