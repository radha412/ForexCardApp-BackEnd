package com.card.forexapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Admin;
import com.card.forexapp.exception.AdminException;
import com.card.forexapp.repository.AdminRepository;

@Service
public class AdminService  {
	
	@Autowired
	AdminRepository adminRepository ;
	
	public List<Admin> getAllAdmin(){
		return this.adminRepository.findAll();
	}

	public Admin createNewAdmin(Admin admin, Integer adminId) throws AdminException {
		if(admin.getIsAdmin()==null)
			admin.setIsAdmin(false);
		else
			admin.setIsAdmin(true);
		Optional<Admin> adminOpt= this.adminRepository.findById(adminId);
		Admin presentAdmin = adminOpt.get();
		if(!presentAdmin.getIsAdmin())
			throw new AdminException("Admin is not superAdmin . ");
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encrpytedPassword = bcrypt.encode(admin.getPassword());
		admin.setPassword(encrpytedPassword);
		return this.adminRepository.save(admin);
	}

	public Admin getAdminByName(Integer adminUserId) throws AdminException {
		Optional<Admin> adminOpt = this.adminRepository.findById(adminUserId);
		if(!adminOpt.isPresent())
			throw new AdminException("Admin not found!!!");
		Admin admin = adminOpt.get();
		return admin;
	}

	public Admin getAdminByUserName(String adminUserName) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin = this.adminRepository.findAdminByUserName(adminUserName);
		if(admin==null)
			throw new AdminException("Admin not found");
		return admin;
	}

	public Boolean verifyAdmin(String username, String password) throws AdminException{
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Admin admin = this.getAdminByUserName(username);
		System.out.println(admin);
		if(admin==null)
			throw new AdminException("Admin not found");
		if(bcrypt.matches(password, admin.getPassword())) 
			return false;
		return true;
	}

	public Admin createNewAdminwITHOUT(Admin admin) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encrpytedPassword = bcrypt.encode(admin.getPassword());
		admin.setPassword(encrpytedPassword);
		return this.adminRepository.save(admin);
		
	}


}
