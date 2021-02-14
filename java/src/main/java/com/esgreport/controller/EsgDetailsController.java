package com.esgreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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



	@GetMapping("/all")
	public List<EsgDetail> esgDetails() {

		return egDetailService.findAll();
	}

	@GetMapping("/list")
	public String esgDetailsList() {

		return "EsgDetailsList";
	}


	@PostMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public String esgDetailsSave(@RequestBody EsgDetailModel esgDetailModel) {
		
		System.out.println(esgDetailModel.getTxtactivities() + " hey " + esgDetailModel.getTxtheadquarters());
		try {
			egDetailService.save(esgDetailModel);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EsgDetails Inserted";
	}

	@PostMapping("/update")
	public String esgDetailsUpdate() {
		return "EsgDetailsUpdate";
	}
}

