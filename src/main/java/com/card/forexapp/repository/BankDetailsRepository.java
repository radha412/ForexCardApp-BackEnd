package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

}
