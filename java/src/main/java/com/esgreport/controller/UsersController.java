package com.esgreport.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.entity.User;
import com.esgreport.service.UserServices;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/email")
public class UsersController {
	 @Autowired
	    private UserServices service;
	 
	     
	    @PostMapping("/process_register")
	    public String processRegister(User user, HttpServletRequest request)
	            throws UnsupportedEncodingException, MessagingException {
	        service.register(user, getSiteURL(request));       
	        return "register_success";
	    }
	     
	    private String getSiteURL(HttpServletRequest request) {
	        String siteURL = request.getRequestURL().toString();
	        return siteURL.replace(request.getServletPath(), "");
	    }  
	     
}
