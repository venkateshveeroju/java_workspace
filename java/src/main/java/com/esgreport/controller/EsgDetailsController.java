package com.esgreport.controller;

import java.text.ParseException;
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
import com.esgreport.model.EsgDetailsData;
import com.esgreport.model.EsgDetailsDelegateUserModel;
import com.esgreport.service.EsgDetailService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/esgdetails")
public class EsgDetailsController {

	@Autowired
	private EsgDetailService esgDetailService;

	@GetMapping("/all")
	public List<EsgDetail> esgDetails() {

		return esgDetailService.findAll();
	}

	@GetMapping("/getesgdetails")
	public List<EsgDetail> esgDetailsList() {

		return esgDetailService.findAll();
	}

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public String esgDetailsSave(@RequestBody EsgDetailsData esgdetailsdata) throws ParseException {

		try {
			esgDetailService.save(esgdetailsdata);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "EsgDetails Inserted";
	}

	@PostMapping(value = "/delegate", produces = MediaType.APPLICATION_JSON_VALUE)
	public String esgDetailsDelegate(@RequestBody EsgDetailsDelegateUserModel esgDetailsDelegateUserModel)
			throws ParseException {

		try {
			esgDetailService.delegate(esgDetailsDelegateUserModel);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Delegate successfull";
	}

	@PostMapping("/update")
	public String esgDetailsUpdate() {
		return "EsgDetailsUpdate";
	}

	@PostMapping("/updatedelegateto")
	public boolean esgDetailsUpdateDelegateTo(@RequestBody EsgDetailsDelegateUserModel esgDetailsDelegateUserModel) throws ParseException {
		try {
			esgDetailService.delegate( esgDetailsDelegateUserModel);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
