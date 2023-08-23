package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.LoadingTranscation;
import com.card.forexapp.service.LoadingTranscationService;



@RestController
public class LoadingTranscationController {
	
	@Autowired
	LoadingTranscationService loadingTranscationService;
	
	@GetMapping("/payments")
	public List<LoadingTranscation> getAllPayments(){
		return this.loadingTranscationService.getAllPayments();
	}

}
