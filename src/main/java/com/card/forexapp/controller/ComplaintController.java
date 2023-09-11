package com.card.forexapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.Complaint;
import com.card.forexapp.repository.ComplaintRepository;
import com.card.forexapp.service.ComplaintService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComplaintController {
	
	@Autowired
	ComplaintRepository ComplaintRepo;
	
	@Autowired
	ComplaintService complaintService;
	
	@PostMapping("customer/complaint")
    public Complaint ComplaintPriority(@RequestBody Complaint complaint) {
		System.out.println(complaint.getDescription());
         return this.complaintService.ComplaintPriority(complaint);
         
    }

    @GetMapping("/allComplaints")
    public List<Complaint> getAllComplaints() {
        return ComplaintRepo.findAll();
    }


}
