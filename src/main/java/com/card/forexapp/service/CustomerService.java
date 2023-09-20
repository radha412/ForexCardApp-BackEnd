package com.card.forexapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.card.forexapp.dto.CustomerDTO;
import com.card.forexapp.dto.ForexCardDTO;
import com.card.forexapp.dto.PotentialCustomerDTO;
import com.card.forexapp.entity.Customer;
import com.card.forexapp.entity.ForexCard;
import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.exception.CustomerException;
import com.card.forexapp.exception.PotentialCustomerException;
import com.card.forexapp.repository.CustomerRepository;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PotentialCustomersService potentialCustomerService;
	
	@Autowired
	private ForexCardService forexCardService;
	
	@Autowired
	private EmailService emailService;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Integer countCustomers() {
		return (int) this.customerRepository.count();	
	}
	
	public void updateResetPasswordToken(String token, String email) throws CustomerException {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            customer.setResetPasswordToken(token);
            customerRepository.save(customer);
        } else {
            throw new CustomerException("Could not find any customer with the email " + email);
        }
    }
     
    public Customer getByResetPasswordToken(String token) {
        return customerRepository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(Customer customer, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodedPassword);
         
        customer.setResetPasswordToken(null);
        customerRepository.save(customer);
    }

	public void createNewCustomer(Customer customer) {
		this.customerRepository.save(customer);
		
	}
	
	public void submitCustomerDetails(CustomerDTO customerDto) throws PotentialCustomerException, MessagingException {

		Customer customer = this.modelMapper.map(customerDto, Customer.class);
	
	//	this.potentialCustomerService.deletePotentialCustomer(customerDto.getCustomerId());
		
		System.out.println(customer.getAdhaarCardNumber());

		ForexCardDTO forexCardDTO = this.forexCardService.generateForexCardDetails();

		ForexCard forexcard = this.modelMapper.map(forexCardDTO, ForexCard.class);

		forexcard.setCustomer(customer);
		forexcard.setPin(234567);
		forexcard.setActivate(true);
		forexcard.setCurrentBalance(0.0);
		ForexCardDetails forexCardDetails = this.forexCardService.getForexCardByNumber(1);
		forexcard.setForexCardDetails(forexCardDetails);
		customer.setForexCard(forexcard);
		
		
		PotentialCustomerDTO potentialCustomer = this.modelMapper.map(customer, PotentialCustomerDTO.class);
		this.potentialCustomerService.savePotentialCustomerDetails(potentialCustomer);
		this.customerRepository.save(customer);

		this.forexCardService.forexCardRepo.save(forexcard);

		
System.out.println(customer.getEmail());
		String message = "Your Forex Card Number is  " + forexcard.getForexCardNumber() + " cvv is " + forexcard.getCvv() + " expriy date " + forexcard.getExpiryDate() +

				"Forex Card pin "+forexcard.getPin()+" your customer id is " + customer.getCustomerId();

		//call email service

		this.emailService.sendForexCardDetailsMessage(customer.getEmail(), "Forex Card Details",message);

		

	}


	
	public Double showCurrentBalance(Long forexCardNumber,Integer pin)throws CustomerException{

		Optional<ForexCard>forexCardOpt=this.forexCardService.forexCardRepo.findByForexCardNumber(forexCardNumber);

		ForexCard forexCard=forexCardOpt.get();

		Double currentBalance;

		if(forexCard==null)

			throw new CustomerException("Invalid Card");

		Integer customerPin=forexCard.getPin();

		System.out.println(customerPin);

		System.out.println(pin);

		if(pin.equals(customerPin)) {

		      currentBalance=forexCard.getCurrentBalance();

		}

		else

			throw new CustomerException("Invalid Pin");

		

		return currentBalance;

		

		

	}

	public Customer getById(Long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customerOpt=this.customerRepository.findById(customerId);
		return customerOpt.get();
	}

}
