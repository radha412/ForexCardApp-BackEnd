package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.LoadingTranscation;
import com.card.forexapp.repository.LoadingTranscationRepository;



@Service
public class LoadingTranscationService {
	
	@Autowired
	LoadingTranscationRepository loadingTranscationRepository;

	public List<LoadingTranscation> getAllPayments()  {
		return this.loadingTranscationRepository.findAll();
	}

}
