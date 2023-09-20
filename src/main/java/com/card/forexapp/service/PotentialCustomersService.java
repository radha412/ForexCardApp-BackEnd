package com.card.forexapp.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.card.forexapp.dto.OTPDto;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.Admin;
import com.card.forexapp.entity.PotentialCustomers;
import com.card.forexapp.exception.AdminException;
import com.card.forexapp.exception.EmailVerificationException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.repository.PotentialCustomerRepository;

import jakarta.mail.MessagingException;

@Service
public class PotentialCustomersService {
	
	@Autowired
	private PotentialCustomerRepository potentialCustomerRepo;
	
	@Autowired
	private OTPService optService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/*
	 *  i can send the dto here*/
	public PotentialCustomers findPotentialCustomerById(Long potentialCustomerId) throws PotentialCustomerException {
		Optional<PotentialCustomers> potentialCustomerOpt = this.potentialCustomerRepo.findById(potentialCustomerId);
		if(potentialCustomerOpt.isEmpty()) {
			throw new PotentialCustomerException("Invalid customer Id");
		}
		
		return potentialCustomerOpt.get();
	}
	//give the message OTP has sent successfully
	public void generateOtpForEmailVerification(PotentialCustomerDTO potnentialCustomer) throws EmailVerificationException {
		String userEmail = potnentialCustomer.getEmail();
		Integer generatedOTP  = optService.generateOTP(userEmail);
		String message = generatedOTP + " is your OTP for email verification. Don't share your otp with anyone. This Otp is valid only for 3 mninutes";
		try {
		this.emailService.sendOtpMessage(userEmail, "OTP For Email Verification", message);
		}//give the reason
		catch(MessagingException exception) {
			throw new EmailVerificationException("Email Cannot Be Sent");
		}
	}

	public Boolean verifyOtpforEmailVerification(OTPDto otpDto) throws EmailVerificationException{
		String clientEmail = otpDto.getCustomerEmail();
		Integer clientOTP = otpDto.getOtp();
		
		Boolean isVerified = this.optService.validateOTP(clientEmail, clientOTP);
		
		if(! isVerified)
		{
			throw new EmailVerificationException("You have entered wrong OTP");
		}
		return true;
	}
	
	public void setPassword(PotentialCustomerDTO potentialCustomerDto) {
		PotentialCustomers potentialCustomer = modelMapper.map(potentialCustomerDto, PotentialCustomers.class);
		this.potentialCustomerRepo.save(potentialCustomer);
	}

	public void savePotentialCustomerDetails(PotentialCustomerDTO potentialCustomerDto) {
		//saving the data of potential customer data
		PotentialCustomers potentialCustomer = this.modelMapper.map(potentialCustomerDto, PotentialCustomers.class);
		this.potentialCustomerRepo.save(potentialCustomer);
	}

	public Boolean verifyLoginCredentials(PotentialCustomerDTO potentialCustomerDto) throws PotentialCustomerException {
		Optional<PotentialCustomers> potentialCustomerOpt = this.potentialCustomerRepo.findByEmail(potentialCustomerDto.getEmail());
		System.out.println(potentialCustomerOpt.get().getEmail());
		if(potentialCustomerOpt.isEmpty()) {
			throw new PotentialCustomerException("You are not a registered user.Please SignUp");
		}
		System.out.println(potentialCustomerOpt.get().getEmail());
		PotentialCustomers potentialCustomer = potentialCustomerOpt.get();
		String email = potentialCustomer.getEmail();
		String password = potentialCustomer.getPassword();
		System.out.println(password);
		if(!email.equals(potentialCustomerDto.getEmail())) {
			throw new PotentialCustomerException("You have entered a wrong email");
		}
		
		if(!password.equals(potentialCustomerDto.getPassword())){
			throw new PotentialCustomerException("You have entered a wrong password");
		}
		
		return true;
	}
	
	public PotentialCustomerDTO deletePotentialCustomer(Long potentialCustomerId) throws PotentialCustomerException {
		
		PotentialCustomers potentialCustomer = findPotentialCustomerById(potentialCustomerId);
		this.potentialCustomerRepo.deleteById(potentialCustomerId);
		PotentialCustomerDTO potentialCustomerDTO = this.modelMapper.map(potentialCustomer, PotentialCustomerDTO.class);
		return potentialCustomerDTO;
	}
	public Boolean verifyAdmin(String username, String password) {
		Optional<PotentialCustomers> potencialCustomerOpt = this.potentialCustomerRepo.findByEmail(username);
		PotentialCustomers potencialCustomer = potencialCustomerOpt.get();
		System.out.println(potencialCustomer);
		if(potencialCustomer==null)
			return false;
		
		return true;
	}
	public PotentialCustomers getAdminByUserName(String username) {
		Optional<PotentialCustomers> potencialCustomerOpt = this.potentialCustomerRepo.findByEmail(username);
		return potencialCustomerOpt.get();
	}
	public List<PotentialCustomers> getAllCustomers() {
		// TODO Auto-generated method stub
		return this.potentialCustomerRepo.findAll();
	}
}
