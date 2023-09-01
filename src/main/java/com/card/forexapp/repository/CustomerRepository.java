package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.card.forexapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.customerEmail = ?1")
    public Customer findByEmail(String customerEmail); 
     
    public Customer findByResetPasswordToken(String token);

}
