package com.card.forexapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.PotentialCustomers;

public interface PotentialCustomerRepository extends JpaRepository<PotentialCustomers, Long> {

	Optional<PotentialCustomers> findByEmail(String email);

}
