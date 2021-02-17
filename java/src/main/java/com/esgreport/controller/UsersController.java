package com.esgreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.User;
import com.esgreport.repository.UserRepository;
import com.esgreport.service.EsgDetailService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users/")
public class UsersController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/all")
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@GetMapping("/getuserslist")
	public List<User> getUSersList() {

		return userRepository.findAll();
	}
	     
}
