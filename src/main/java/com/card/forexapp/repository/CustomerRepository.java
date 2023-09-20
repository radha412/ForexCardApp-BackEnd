package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.card.forexapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
    public Customer findByEmail(String customerEmail); 
     
	@Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
    public Customer findById(Integer id); 
	
    public Customer findByResetPasswordToken(String token);

}
