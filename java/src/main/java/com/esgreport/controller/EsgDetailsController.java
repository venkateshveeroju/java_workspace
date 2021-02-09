package com.esgreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.esgreport.entity.EsgDetail;
import com.esgreport.repository.EsgDetailRepository;
import com.esgreport.service.EsgDetailService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/esg")
public class EsgDetailsController {
	
	private final EsgDetailService esgDetailImpl ;
	
	private EsgDetailRepository esgDetailRepository;
	
	@Autowired
	public   EsgDetailsController(EsgDetailService esgDetailImpl) {
		this.esgDetailImpl = esgDetailImpl;
	}
	

	
	@GetMapping("/all")
	public List<EsgDetail> esgDetails () {
		if(esgDetailRepository.findAll().isEmpty()) {
			//return List<EsgDetail>;
		}
		return esgDetailRepository.findAll();
	}
	@GetMapping("/list")
	public String esgDetailsList () {
	
		return "EsgDetailsList";
	}
	@PutMapping("/insert")
	public String esgDetailsInsert (String generalDisclosure) {
		
		return "EsgDetails Inserted";
	}
	@PostMapping("/update")
	public String esgDetailsUpdate () {
		return "EsgDetailsUpdate";
	}
}
