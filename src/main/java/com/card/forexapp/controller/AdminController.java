package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.Admin;
import com.card.forexapp.service.AdminService;



@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/admin")
	public List<Admin> getAllAdmins(){
		return this.adminService.getAllAdmin();
	}

}
