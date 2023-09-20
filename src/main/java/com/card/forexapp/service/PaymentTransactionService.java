package com.card.forexapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.card.forexapp.entity.Customer;
import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.entity.PaymentTransaction;
import com.card.forexapp.exception.CustomerException;
import com.card.forexapp.exception.PaymentTransactionException;
import com.card.forexapp.repository.PaymentTransactionRepository;

 

 

@Service
public class PaymentTransactionService {


	@Autowired
	CustomerService customerService;

	@Autowired
	 PaymentTransactionRepository  paymentTransactionRepo;

	@Autowired
	ForexCardService forexCardService;


	public List<PaymentTransaction> getAllTransaction(){
		return this.paymentTransactionRepo.findAll();
	}

public Boolean forexCardValidation(Long customerId,ForexCard forexCardValidation)
		throws PaymentTransactionException, CustomerException{
	Customer customer;
	customer = this.customerService.getById(customerId);

		if(customer==null) {
			throw new CustomerException("Customer not found");
		}

		 ForexCardDetails forexcardDetails = customer.getForexCard().getForexCardDetails();

		ForexCard forexCard=customer.getForexCard();
		String cardHolderName=forexCard.getCardHolderName();
		Long forexCardNumber=forexCard.getForexCardNumber();
		Integer cvv=forexCard.getCvv();
		Integer pin=forexCard.getPin();
		java.time.LocalDate expiryDate=forexCard.getExpiryDate();
		Double balance=forexCard.getCurrentBalance();
//		Double platformCharges=forexcardDetails.getPlatformfee();

		String cardHolderNameCustomer=forexCardValidation.getCardHolderName();	
		Long forexCardNumberCustomer=forexCardValidation.getForexCardNumber();
		Integer cvvCustomer=forexCardValidation.getCvv();
		java.time.LocalDate expiryDateCustomer=forexCardValidation.getExpiryDate();
		Integer pinCustomer=forexCardValidation.getPin();

 

		if(!(cardHolderName.equals(cardHolderNameCustomer))||
				!(forexCardNumber.equals(forexCardNumberCustomer))||
				!(cvv.equals(cvvCustomer))||
				!(expiryDate.equals(expiryDateCustomer))) {
			throw new PaymentTransactionException("Any one of the fields is invalid");
		}
		else if(!forexCard.isActivate())
			throw new PaymentTransactionException("Card is deactivated");
			else
				return true;
}

public Boolean withdrawFromForexCard(Long forexCardNumber,
		Integer pin,PaymentTransaction paymentTransaction)
		throws CustomerException, PaymentTransactionException{
	
////	Optional<Customer> customerOpt = this.customerService.customerRepository.findById(customerId);
//	Customer customer;
//	customer = this.customerService.getById(customerId);
//	System.out.println(customer.toString());
//	System.out.println(customer);
//		if(customer==null) 
//			throw new CustomerException("Customer not found");

		String merchant=paymentTransaction.getMerchant();
		  Double amount=paymentTransaction.getAmount();
		  String currency=paymentTransaction.getCurrency();
		  String paymentMethod=paymentTransaction.getPaymentMethod();
		  LocalDateTime paymentTransactionTime=paymentTransaction.setTransactionDateTime(LocalDateTime.now());
		  String paymentStatus=paymentTransaction.setPaymentStatus("Failure");

		  Optional<ForexCard> forexCardOpt = this.forexCardService.forexCardRepo.findByForexCardNumber(forexCardNumber);
		  ForexCard forexCard= forexCardOpt.get();
		  if(forexCard==null)
			  throw new PaymentTransactionException("Forex card number is not valid!!");
		  ForexCardDetails forexcardDetails = forexCard.getForexCardDetails();
		  System.out.println(forexcardDetails.toString());
		  Double balance=forexCard.getCurrentBalance();
//			Double platformCharges=forexCard.getForexCardDetails().getPlatformfee();
			Double manualSpendingLimit=forexCard.getManualSpendingLimit();
			Double maxSpendingLimit=forexCard.getForexCardDetails().getMaxSpendingLimit();
			
			Integer validationPin=forexCard.getPin();
			if(!validationPin.equals(pin)) {
			    paymentStatus=paymentTransaction.setPaymentStatus("failure");
	            this.paymentTransactionRepo.save(paymentTransaction);
	            throw new PaymentTransactionException("Invalid pin");
			}
			else if(amount<=balance)
				{
					balance=balance-(amount
//							+platformCharges
							);
					forexCard.setCurrentBalance(balance);
					this.forexCardService.updateForexCard(forexCard);
					paymentStatus=paymentTransaction.setPaymentStatus("Success");
					this.paymentTransactionRepo.save(paymentTransaction);
					return true;

				}
			else
					 paymentStatus=paymentTransaction.setPaymentStatus("Failure");
			         this.paymentTransactionRepo.save(paymentTransaction);
					 throw new PaymentTransactionException("Amount is invalid");

}
 

	
	public Boolean depositToForexCard(Long customerId,Double depositAmount,PaymentTransaction paymentTransaction)throws PaymentTransactionException, CustomerException{

		Customer customer;
		customer = this.customerService.getById(customerId);
		String paymentStatus=paymentTransaction.setPaymentStatus("Failure");
		if(customer==null) {
			throw new CustomerException("Customer not found");
		}
		ForexCard forexCard=customer.getForexCard();
		Double balance=forexCard.getCurrentBalance();

		if(!forexCard.isActivate()) {
				throw new PaymentTransactionException("Card is deactivated");
		}

			balance=balance+depositAmount;
			forexCard.setCurrentBalance(balance);
			this.forexCardService.updateForexCard(forexCard);
			paymentStatus=paymentTransaction.setPaymentStatus("Success");
			this.paymentTransactionRepo.save(paymentTransaction);
			

			return true;
	}

	}