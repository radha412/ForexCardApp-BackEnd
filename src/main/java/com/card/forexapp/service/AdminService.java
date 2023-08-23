package com.card.forexapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Admin;
import com.card.forexapp.repository.AdminRepository;



@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository ;
	
	public List<Admin> getAllAdmin(){
		return this.adminRepository.findAll();
	}

}
