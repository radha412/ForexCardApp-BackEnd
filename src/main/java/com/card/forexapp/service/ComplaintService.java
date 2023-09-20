package com.card.forexapp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Complaint;
import com.card.forexapp.repository.ComplaintRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class ComplaintService {
	
	@Autowired
	ComplaintRepository ComplaintRepo;
	
	public Complaint ComplaintPriority(Complaint complaint) {
		Long id = complaint.getId();
		String complaintCategory=(complaint.getDescription());
		LocalDateTime complaintTime=complaint.setComplainTime(LocalDateTime.now());
		String userName=complaint.getCustomerName();
		if(complaintCategory == null) {
			complaint.setPriority(com.card.forexapp.entity.ComplaintPriority.LOW);
		}
		if("Complaint".equals(complaintCategory)||"COMPLAINT".equals(complaintCategory)||"complaint".equals(complaintCategory)) {
			complaint.setPriority(com.card.forexapp.entity.ComplaintPriority.HIGH);
			this.ComplaintRepo.save(complaint);

				 Twilio.init("AC42f4a4eec63e914759119a868d3dc8cb", "c80a5ff9ce15b11c2d61811f5bcca80f");
				 Message message = Message.creator(
				     new PhoneNumber(complaint.getPhoneNumber()),
				     new PhoneNumber("+13343452224"),
				    "Hi"+" "+userName+". Thanks for reaching out, we have recieved your complain. Our team will call you within 2-3 hr.")
				 .create();
		}
		else
		{
			complaint.setPriority(com.card.forexapp.entity.ComplaintPriority.LOW);
			this.ComplaintRepo.save(complaint);
			Twilio.init("AC42f4a4eec63e914759119a868d3dc8cb", "c80a5ff9ce15b11c2d61811f5bcca80f");
			 Message message = Message.creator(
			     new PhoneNumber(complaint.getPhoneNumber()),
			     new PhoneNumber("+13343452224"),
			     "Hi"+" "+userName+". Thanks for reaching out, we have recieved your enquiry. Our team will call you within 24 hrs.")
			 .create();
		}
		this.ComplaintRepo.save(complaint);
		return complaint;
		
	}

}
