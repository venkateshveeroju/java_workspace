package com.esgreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/esg")
public class EsgController {
	
	
	@GetMapping("/all")
	public String esgDetails () {
		return "esgDetails";
	}
	@GetMapping("/list")
	public String esgDetailsList () {
		return "EsgDetailsList";
	}
	@PutMapping("/insert")
	public String esgDetailsInsert () {
		return "EsgDetailsInsert";
	}
	@PostMapping("/update")
	public String esgDetailsUpdate () {
		return "EsgDetailsUpdate";
	}
}
