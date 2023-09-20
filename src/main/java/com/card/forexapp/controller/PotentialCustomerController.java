package com.card.forexapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.card.forexapp.dto.OTPDto;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.Admin;
import com.card.forexapp.entity.PotentialCustomers;
import com.card.forexapp.exception.AdminException;
import com.card.forexapp.exception.EmailVerificationException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.service.PotentialCustomersService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PotentialCustomerController {
	
	@Autowired
	PotentialCustomersService potentialCustomerservice;
	
	@GetMapping("/potencialcustomers/")
	public ResponseEntity<List<PotentialCustomers>> getAllCustomers(){
		List<PotentialCustomers> potencialCustomers = this.potentialCustomerservice.getAllCustomers();
		
		return ResponseEntity.ok(potencialCustomers);
	}

	@PostMapping("/potential-customer/generate-otp")
	public ResponseEntity<String> getOTPForEmailVerification(@RequestBody PotentialCustomerDTO potentialCustomer) throws EmailVerificationException{
			 this.potentialCustomerservice.generateOtpForEmailVerification(potentialCustomer);
			 return  ResponseEntity.ok("Email sent successfully");
	}

	@PostMapping("/potential-customer/email-verification")
	public ResponseEntity<String> verifyOtpForEmailVerification(@RequestBody OTPDto otpDto) throws EmailVerificationException{
		this.potentialCustomerservice.verifyOtpforEmailVerification(otpDto);
		 return ResponseEntity.ok("Email Got Verified");
	}

	@PostMapping("/potential-customer/set-password")
	public ResponseEntity<String> setPassword(@RequestBody PotentialCustomerDTO potentialCustomer){
		this.potentialCustomerservice.setPassword(potentialCustomer);
		return ResponseEntity.ok("Login Successfully");
	}
	
	@PostMapping("/poential-customer/save-details")
	public ResponseEntity<String> savePotentialCustomerDetails(@RequestBody PotentialCustomerDTO potentialCustomerDto){
		this.potentialCustomerservice.savePotentialCustomerDetails(potentialCustomerDto);
		return ResponseEntity.ok("Details Saved Successfully");
	}
	
	@PostMapping("/potential-customer/login-credentials/")
	public ResponseEntity<PotentialCustomerDTO> verifyLoginCredentials(@RequestBody PotentialCustomerDTO potentialCustomerDto) throws PotentialCustomerException{
		 this.potentialCustomerservice.verifyLoginCredentials(potentialCustomerDto);
		return ResponseEntity.ok(potentialCustomerDto);
	}
//	@GetMapping("/potential-customer/")
//	public ResponseEntity<PotentialCustomers> verifyAdmin(@RequestBody PotentialCustomers potencialCustomer) throws PotentialCustomerException {
//		Boolean verifiedAdmin = this.potentialCustomerservice.verifyAdmin(potencialCustomer.getEmail(),potencialCustomer.getPassword());
////		PotentialCustomers _potentialCustomerservice = this.potentialCustomerservice.getAdminByUserName(potencialCustomer.getEmail());
//		if(verifiedAdmin==false)
//			return ResponseEntity.ok(potencialCustomer);
//		return ResponseEntity.ok(potencialCustomer);		
//	}
}
