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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.esgreport.entity.EsgDetail;
import com.esgreport.model.EsgDetailModel;
import com.esgreport.repository.EsgDetailRepository;
import com.esgreport.service.EsgDetailService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/esgdetails")
public class EsgDetailsController {

	@Autowired
	private  EsgDetailService egDetailService;
	
	@Autowired
	private EsgDetailModel esgDetailModel ;
	
	@GetMapping("/all")
	public List<EsgDetail> esgDetails() {
		
		return egDetailService.findAll();
	}

	@GetMapping("/list")
	public String esgDetailsList() {

		return "EsgDetailsList";
	}

	//dummy data
//	{
//		   "txtactivities": "activities",
//		"txtheadquarters": "headquarters",
//		"txtoperations": "operations",
//		"txtorganization": "organization"
//		}
	@PostMapping("/save")
	public String esgDetailsSave(@RequestBody EsgDetailModel incomingData) {
		System.out.println(incomingData.getTxtactivities() +" hey "+incomingData.getTxtheadquarters());
		
//		esgDetailModel.setTxtActivities(incomingData.getTxtActivities());
//		esgDetailModel.setTxtLocation(incomingData.getTxtLocation());
//		esgDetailModel.setTxtOrganizationName(incomingData.getTxtOrganizationName());
//		
		//System.out.println(esgDetailModel);
		return "EsgDetails Inserted";
	}

	@PostMapping("/update")
	public String esgDetailsUpdate() {
		return "EsgDetailsUpdate";
	}
}
