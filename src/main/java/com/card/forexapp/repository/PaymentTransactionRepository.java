package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.PaymentTransaction;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {

}
