package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
