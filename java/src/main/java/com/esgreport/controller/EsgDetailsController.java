package com.esgreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.entity.EsgDetail;
import com.esgreport.model.EsgDetailModel;
import com.esgreport.service.EsgDetailService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/esgdetails")
public class EsgDetailsController {

	@Autowired
	private EsgDetailService egDetailService;

	@Autowired
	private EsgDetailModel esgDetailModel;

	@GetMapping("/all")
	public List<EsgDetail> esgDetails() {

		return egDetailService.findAll();
	}

	@GetMapping("/list")
	public String esgDetailsList() {

		return "EsgDetailsList";
	}

	// dummy data
//	{
//		   "txtactivities": "activities",
//		"txtheadquarters": "headquarters",
//		"txtoperations": "operations",
//		"txtorganization": "organization"
//		}
	@PostMapping("/save")
	public String esgDetailsSave(@RequestBody EsgDetailModel esgDetailModel) {
		System.out.println(esgDetailModel.getTxtactivities() + " hey " + esgDetailModel.getTxtheadquarters());
		egDetailService.save(esgDetailModel);
		return "EsgDetails Inserted";
	}

	@PostMapping("/update")
	public String esgDetailsUpdate() {
		return "EsgDetailsUpdate";
	}
}

