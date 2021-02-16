package com.esgreport.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.SendingEmailApplication;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/email")
public class SendEmailController {
	
	@Autowired
	SendingEmailApplication sendingEmailApplication;

	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
		sendingEmailApplication.sendEmail();
		//sendingEmailApplication.sendEmailWithAttachment();
	   return "Email sent successfully";   
	}
}