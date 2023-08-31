package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.card.forexapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("Select admin from Admin admin where adminEmail=?1")
	Admin findAdminByUserName(String adminUserName);

}
