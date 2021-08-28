package com.esgreport.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.SendingEmailApplication;
import com.esgreport.entity.Contact;
import com.esgreport.repository.SendingMailService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class ContactController {
	@Autowired
	SendingMailService sendingMailService;
	
	@Autowired
	SendingEmailApplication sendingEmailApplication;

	@GetMapping("/")
	public String index() {
		return "redirect:/form";
	}

	@GetMapping("/form")
	public String formGet(Model model) {
		model.addAttribute("contact", new Contact());
		return "form";
	}

	@PostMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
	public String formsubmit(@RequestBody Contact contact) throws Throwable, IOException {
		if (contact == null) {
			return "error";
		}
		System.out.println(contact.toString());
		sendingEmailApplication.sendEmailContact(contact);
		
		return "Success - 200";
	}

	@PostMapping("/form")
	public String formPost(@Valid Contact contact, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "form";
		}

		model.addAttribute("noErrors", true);
		model.addAttribute("contact", contact);
		String subject = contact.getName() + " " + contact.getEmail() + " sent you a message";
		sendingMailService.sendMail(contact.getEmail(), subject, contact.getMessage());
		return "form";
	}
}
