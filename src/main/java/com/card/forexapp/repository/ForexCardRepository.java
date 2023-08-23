package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.ForexCard;

public interface ForexCardRepository extends JpaRepository<ForexCard, Integer> {

}
