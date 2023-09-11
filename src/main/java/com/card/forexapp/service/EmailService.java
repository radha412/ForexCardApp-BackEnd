package com.card.forexapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.Email;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	   
    public String sendSimpleMail(Email emailDetails)
    {
        try {
        	SimpleMailMessage mailMessage= new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom("radhikarudrawar11@gmail.com");
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
           
            return "Mail Sent Successfully...";
        }
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
    
    @Scheduled(fixedRate = 365*86400*1000)
    public String sendMessagePeriodically(String emailTo) {
    	try {
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            mailMessage.setFrom("radhikarudrawar11@gmail.com");
            mailMessage.setTo(emailTo);
            mailMessage.setText("Remainder for renewing your forexcardapplication . ");
            mailMessage.setSubject("Renewing Forex Card");
 
            javaMailSender.send(mailMessage);
            
            return "Mail Sent Successfully...";
        }
 
        catch (Exception e) {
            return "Error while Sending Mail";
        }
        
    }
 
}