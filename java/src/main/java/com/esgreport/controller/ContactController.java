package com.esgreport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.esgreport.entity.Contact;
import com.esgreport.repository.SendingMailService;

public class ContactController {
	@Autowired
	SendingMailService sendingMailService;

	@GetMapping("/")
	public String index() {
		return "redirect:/form";
	}

	@GetMapping("/form")
	public String formGet(Model model) {
		model.addAttribute("contact", new Contact());
		return "form";
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
