package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Customer;
import com.card.forexapp.exception.CustomerException;
import com.card.forexapp.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

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

}
