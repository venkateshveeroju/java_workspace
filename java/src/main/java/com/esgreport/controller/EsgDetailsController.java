package com.esgreport.controller;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esgreport.GeneratePdf;
import com.esgreport.SendingEmailApplication;
import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.User;
import com.esgreport.model.EsgDetailsData;
import com.esgreport.model.EsgDetailsDelegateUserModel;
import com.esgreport.service.EsgDetailService;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/esgdetails")
public class EsgDetailsController {
	@Autowired
	private SendingEmailApplication sendingEmailApplication;
	@Autowired
	private EsgDetailService esgDetailService;
	@Autowired
	private GeneratePdf generatePdf;
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
		if (esgDetailsDelegateUserModel == null) {
			return null;
		}
		try {
			esgDetailService.delegate(esgDetailsDelegateUserModel);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Delegate successfull";
	}

	@GetMapping("/getpdf")
	public String esgDetailsUpdate() {
		generatePdf.generatePdfDocument();
		return "EsgDetailsUpdate";
	}

	@PostMapping("/updatedelegateto")
	public boolean esgDetailsUpdateDelegateTo(@RequestBody EsgDetailsDelegateUserModel esgDetailsDelegateUserModel)
			throws ParseException {
		try {
			esgDetailService.delegate(esgDetailsDelegateUserModel);
			List<EsgDetail> listEsgDetail = esgDetailService.findAll();
			for (int i = 0; i < listEsgDetail.size(); i++) {
				if (listEsgDetail.get(i).getModeratorStatusId().getId() != 2) {
					String email = listEsgDetail.get(i).getDelegateTo().getEmail();
					sendingEmailApplication.sendEmail(email, "Delegation for ESG Tool",
							"Hello " + listEsgDetail.get(i).getDelegateTo().getUsername() + ","
									+ " \n please fill the ESG details in ESG Tool \n http://localhost:4200/login");
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	@GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
     System.out.println("@GetMapping@GetMapping@GetMapping@GetMapping");  
	 return esgDetailService.exportReport(format);
    }
}
