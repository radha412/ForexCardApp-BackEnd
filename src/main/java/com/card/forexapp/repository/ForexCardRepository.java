package com.card.forexapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.card.forexapp.entity.ForexCard;

public interface ForexCardRepository extends JpaRepository<ForexCard, Integer> {
	
	@Query("select card from ForexCard card where forexCardNumber=:cardNumber")
	Optional<ForexCard> findByForexCardNumber(Long cardNumber);
	

}
