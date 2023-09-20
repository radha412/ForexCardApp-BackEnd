package com.card.forexapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.Admin;
import com.card.forexapp.entity.ForexCardDetails;
import com.card.forexapp.exception.AdminException;
import com.card.forexapp.exception.ForexCardDetailsException;
import com.card.forexapp.service.AdminService;
import com.card.forexapp.service.CustomerService;
import com.card.forexapp.service.ForexCardDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ForexCardDetailsService forexCardDetailsService;
	
	@PostMapping("/admin/{adminid}")
	public ResponseEntity<Admin> newAdmin(@RequestBody Admin admin , @PathVariable("adminid") Integer adminId) throws AdminException {
		this.adminService.createNewAdmin(admin,adminId);
		return ResponseEntity.ok(admin);
	}
	
//	@PostMapping("/admin")
//	public ResponseEntity<Admin> newAdmin(@RequestBody Admin admin ) throws AdminException {
//		this.adminService.createNewAdminwITHOUT(admin);
//		return ResponseEntity.ok(admin);
//	}
	
	
	@PostMapping("/admin/forexcard")
	public ResponseEntity<ForexCardDetails> createNewForexCardType(@RequestBody ForexCardDetails forexCardDetails)throws AdminException, ForexCardDetailsException{
		ForexCardDetails forexCardDetail =this.forexCardDetailsService.createnewForexCardType(forexCardDetails);
		return ResponseEntity.ok(forexCardDetail);
		
	}
	
	@PutMapping("/admin/forexcard/{forexcardid}")
	public ResponseEntity<ForexCardDetails> updateForexCardType(@RequestBody ForexCardDetails forexCardDetail,
			@PathVariable("forexcardid") Integer forexcardid) throws AdminException, ForexCardDetailsException{
		ForexCardDetails forexCardDetailFinal =this.forexCardDetailsService.updateForexCardType(forexCardDetail,forexcardid);
		return ResponseEntity.ok(forexCardDetailFinal);
	}
	
	@GetMapping("/admin/{username}/{password}")
	public ResponseEntity<Admin> verifyAdmin(@PathVariable("username") String username , 
							@PathVariable("password") String password) throws AdminException {
		Boolean verifiedAdmin = this.adminService.verifyAdmin(username,password);
		Admin admin = this.adminService.getAdminByUserName(username);
		if(verifiedAdmin==false)
			return ResponseEntity.ok(admin);
		return ResponseEntity.ok(admin);		
	}
	
	@GetMapping("/admin/customers")
	public ResponseEntity<Integer> countCustomers(){
		Integer count = this.customerService.countCustomers();
		return ResponseEntity.ok(count);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAllForexCardDetails(){
		List<Admin> admin = this.adminService.getAllAdmin();
		return ResponseEntity.ok(admin);
	}

}
