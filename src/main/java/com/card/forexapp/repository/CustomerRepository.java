package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
