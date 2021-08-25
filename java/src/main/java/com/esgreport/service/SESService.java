package com.esgreport.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.esgreport.repository.SendingMailService;

@Service
public class SESService implements SendingMailService {


	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(String email,String subject,String message) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setTo("testveertestveer@gmail.com");
//			msg.setSubject("Testing from Spring Boot");
//			msg.setText("Hello World \n Spring Boot Email");
			
			msg.setTo(email);
			msg.setSubject(subject);
			msg.setText(message);

			javaMailSender.send(msg);
			return true;
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}

		return false;
	}

	
}