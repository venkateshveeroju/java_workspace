package com.esgreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.SendingEmailApplication;
import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.User;
import com.esgreport.repository.UserRepository;
import com.esgreport.repository.UserRoleRepository;
import com.esgreport.service.EsgDetailService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users/")
public class UsersController {
	private List<String> emails;
@Autowired
private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private SendingEmailApplication sendingEmailApplication;

	@GetMapping("/all")
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@GetMapping("/getAllUsers")
	public List<User> getUSersList() {
		return userRepository.findAll();
	}

	@PostMapping("/notifyModerators")
	public boolean notifyModerators(String s) {
		System.out.println(userRoleRepository.findModById(2L));
		for (String email : userRoleRepository.findModById(2L)) {
		sendingEmailApplication.sendEmail(email, "ESG Staffil Tool Moderator status update required",
				"Hello Moderator, ESG Data has been submitted, please visit below link to authorize. \n http://localhost:4200/login");
		}
		return true;
	}

}
