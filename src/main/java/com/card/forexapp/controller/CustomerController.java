package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.dto.CustomerDTO;
import com.card.forexapp.entity.Customer;
import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.entity.PaymentTransaction;
import com.card.forexapp.exception.CustomerException;
import com.card.forexapp.exception.PaymentTransactionException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.service.CustomerService;
import com.card.forexapp.service.EmailService;
import com.card.forexapp.service.PaymentTransactionService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	EmailService emailService;

	@Autowired
	PaymentTransactionService paymentService;
	

	@GetMapping("/customers/")
	public List<Customer> getAllUser() {
		return customerService.getAllCustomers();
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> createNewCustomer(Customer customer) {
		this.emailService.sendMessagePeriodically(customer.getEmail());
		this.customerService.createNewCustomer(customer);
		return ResponseEntity.ok(customer);

	}

//	@GetMapping("/customers/{id}")
//
//	public List<Customer> getAllUser(@PathVariable("id") Long customerId) {
//
//		return customerService.getAllCustomers();
//
//	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return this.customerService.getById(id);
	}
//	@PostMapping("customers/submit-customer-details")
//	public ResponseEntity<String> submitCustomerDetails(@RequestBody CustomerDTO customerDto) throws PotentialCustomerException{
//		this.customerService.submitCustomerDetails(customerDto);
//		return ResponseEntity.ok("form submitted successfully");
//	}
	
	@GetMapping("customer/current-balance/{forexCardNumber}/{pin}")

	 public Double displayCurrentBalance(@PathVariable("forexCardNumber")Long forexCardNumber,

			 @PathVariable("pin")Integer pin)throws CustomerException{

		 return this.customerService.showCurrentBalance(forexCardNumber, pin);

	 }
	
	@PostMapping("customers/submit-customer-details")

	public ResponseEntity<String> submitCustomerDetails(@RequestBody CustomerDTO customerDto) throws PotentialCustomerException, MessagingException{

		this.customerService.submitCustomerDetails(customerDto);

		return ResponseEntity.ok("form submitted successfully");

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customer/displaytransactions/{id}")
	public List<PaymentTransaction> getAllTransaction(@PathVariable("id") Long customerId){
		return this.paymentService.getAllTransaction();
	}

	 @PostMapping("/customer/forexCard/validation/{id}")
	 public Boolean forexValidation(@PathVariable("id") Long customerId ,
			 @RequestBody ForexCard forexCardValidation) throws PaymentTransactionException, CustomerException{

		 return this.paymentService.forexCardValidation(customerId,forexCardValidation);
	 }

//	 @PostMapping("/customer/withdrawal/{id}/{pin}")
//	 public Boolean withdrawMoney(@PathVariable("id")Long customerId,
//			 @PathVariable("pin")Integer pin,
//			 @RequestBody PaymentTransaction paymentTransaction)throws PaymentTransactionException, CustomerException{
//		 System.out.println(customerId);
//		 System.out.println(pin);
//		return this.paymentService.withdrawFromForexCard(customerId,pin, paymentTransaction);
//	 }
//
//	 @PostMapping("customer/transaction/{deposit-amount}/{id}")
//	public Boolean depositMoney(@PathVariable("id")Long customerId,
//			@PathVariable("deposit-amount") Double depositAmount) throws PaymentTransactionException, CustomerException {
//		return this.paymentService.depositToForexCard(customerId,depositAmount);
//	 }
}
