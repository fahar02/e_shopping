package com.eshoping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	public EmailService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private JavaMailSender emailSender;
	@Value("${spring.mail.username}")
	private String from;
	
public void sendTextMail(String email,String subject,String otp)
{
	SimpleMailMessage message = new SimpleMailMessage();
	message.setFrom(from);
     message.setTo(email);
     message.setSubject(subject);
     message.setText(otp);
     emailSender.send(message);
}
}
