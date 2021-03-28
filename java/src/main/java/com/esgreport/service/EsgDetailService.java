package com.esgreport.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.esgreport.entity.Bank;
import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.EsgDetailsModeratorStatus;
import com.esgreport.entity.EsgDetailsUserStatus;
import com.esgreport.entity.User;
import com.esgreport.model.EsgDetailsData;
import com.esgreport.model.EsgDetailsDelegateUserModel;
import com.esgreport.payload.response.MessageResponse;
import com.esgreport.repository.BankRepository;
import com.esgreport.repository.EsgDetailRepository;
import com.esgreport.repository.EsgDetailsModeratorStatusRepository;
import com.esgreport.repository.EsgDetailsUserStatusRepository;
import com.esgreport.repository.UserRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EsgDetailService {

	private EsgDetail esgdetail;
	private User user;
	private Bank bank;
	private EsgDetailsUserStatus esgdetailsuserstatus;
	private EsgDetailsModeratorStatus esgdetailsmoderatorstatus;
	private EsgDetailsDelegateUserModel esgDetailsDelegateUserModel;

	@Autowired
	private EsgDetailRepository esgDetailRepository;

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private BankRepository bankrepository;

	@Autowired
	private EsgDetailsModeratorStatusRepository esgdetailsmoderatorstatusrepository;

	@Autowired
	private EsgDetailsUserStatusRepository esgdetailsuserstatusrepository;

	public EsgDetailService(EsgDetailRepository esgDetailRepository) {
		this.esgDetailRepository = esgDetailRepository;

	}

	public List<EsgDetail> findAll() {
		return esgDetailRepository.findAll();
	}

	public long count() {
		return esgDetailRepository.count();
	}

	public void delete() {
		esgDetailRepository.deleteAll();
	}

	public MessageResponse save(EsgDetailsData esgdetailsdata)
			throws IllegalArgumentException, IllegalAccessException, ParseException {
		if (esgdetailsdata == null) {
			return null;
		}

		int bankid = esgdetailsdata.getBank_id();

		Field[] fields1 = esgdetailsdata.getEsgdetailmodel().getClass().getDeclaredFields();
		Field[] fields2 = esgdetailsdata.getEsgdetailusermodifiedmodel().getClass().getDeclaredFields();
		Field[] fields3 = esgdetailsdata.getEsgdetailuserstatusmodel().getClass().getDeclaredFields();
		Field[] fields4 = esgdetailsdata.getEsgdetailmoderatorstatusmodel().getClass().getDeclaredFields();
		Field[] fields5 = esgdetailsdata.getEsgdetaillastmodifiedmodel().getClass().getDeclaredFields();

		for (int i = 0; i < fields1.length; i++) {
			fields1[i].setAccessible(true);
			fields2[i].setAccessible(true);
			fields3[i].setAccessible(true);
			fields4[i].setAccessible(true);
			fields5[i].setAccessible(true);

			//System.out.println(fields1[i].get(esgdetailsdata.getEsgdetailmodel()).toString());
			//System.out.println(fields2[i].get(esgdetailsdata.getEsgdetailusermodifiedmodel()).toString());
			//System.out.println(fields3[i].get(esgdetailsdata.getEsgdetailuserstatusmodel()).toString());
			//System.out.println(fields4[i].get(esgdetailsdata.getEsgdetailmoderatorstatusmodel()).toString());
			//System.out.println(fields5[i].get(esgdetailsdata.getEsgdetaillastmodifiedmodel()).toString());

			esgdetail = new EsgDetail();

			esgdetail = (EsgDetail) esgDetailRepository.findByesgDetailText(fields1[i].getName());
			bank = bankrepository.getOne((long) bankid);
			user = userrepository.getOne(
					(Long.parseLong(fields2[i].get(esgdetailsdata.getEsgdetailusermodifiedmodel()).toString())));

			long us = Long.parseLong(fields3[i].get(esgdetailsdata.getEsgdetailuserstatusmodel()).toString());
			long ms = Long.parseLong(fields4[i].get(esgdetailsdata.getEsgdetailmoderatorstatusmodel()).toString());

			EsgDetailsUserStatus esgdetailsuserstatus = esgdetailsuserstatusrepository.getOne(us);
			EsgDetailsModeratorStatus esgdetailsmoderatorstatus = esgdetailsmoderatorstatusrepository.getOne(ms);

			esgdetail.setEsgDetailTextValue(fields1[i].get(esgdetailsdata.getEsgdetailmodel())!=null? fields1[i].get(esgdetailsdata.getEsgdetailmodel()).toString():"");
			esgdetail.setBank(bank);
			esgdetail.setLastModifiedBy(user);

			// Date ldm = new Date();

			esgdetail.setUserStatusId(esgdetailsuserstatus);
			esgdetail.setModeratorStatusId(esgdetailsmoderatorstatus);

			String s = (fields5[i].get(esgdetailsdata.getEsgdetaillastmodifiedmodel()).toString());
			if(s!=null && s.equals("Y")) {
				esgdetail.setLastModifiedDate(new Date());
				/*
				 * if(fields1[i].getName().equals("txtorganization")) {
				 * fields5[i].get(esgdetailsdata.getEsgdetaillastmodifiedmodel().
				 * getTxtorganizationmodifieddate()); esgdetail.setLastModifiedDate(new Date());
				 * } if(fields1[i].getName().equals("txtactivities")) {
				 * 
				 * } if(fields1[i].getName().equals("txtheadquarters")) {
				 * 
				 * } if(fields1[i].getName().equals("txtoperations")) {
				 * 
				 * }
				 */
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// yyyy-MM-dd'T'HH:mm:ss.SSSXXX
			//Date date = dateFormat.parse(new Date());
			
			

			esgDetailRepository.saveAndFlush(esgdetail);

		}

		return new MessageResponse("Saved successfully");
	}

	@Transactional
	public boolean delegate(EsgDetailsDelegateUserModel esgDetailsDelegateUserModel) {
		if (esgDetailsDelegateUserModel == null) {
			return false;
		}
		List<EsgDetail> esgDetailList = esgDetailRepository.findAll();
		int response = esgDetailRepository.updateDelegate(esgDetailsDelegateUserModel.getTxtorganizationdelegateuser(),
				"txtorganization");
		int txtactivities = esgDetailRepository
				.updateDelegate(esgDetailsDelegateUserModel.getTxtactivitiesdelegateuser(), "txtactivities");
		int txtheadquarters = esgDetailRepository
				.updateDelegate(esgDetailsDelegateUserModel.getTxtheadquartersdelegateuser(), "txtheadquarters");
		int responsetxtoperations = esgDetailRepository
				.updateDelegate(esgDetailsDelegateUserModel.getTxtoperationsdelegateuser(), "txtoperations");
		/*
		 * for (EsgDetail esgDetailTemp : esgDetailList) { try {
		 * if(esgDetailTemp.getEsgDetailText().equals("txtorganization")) { long id =
		 * esgDetailsDelegateUserModel.getTxtorganizationdelegateuser();
		 * esgDetailTemp.setDelegateTo(userrepository.getOne(id));
		 * esgDetailRepository.saveAndFlush(esgDetailTemp); }
		 * if(esgDetailTemp.getEsgDetailText().equals("txtactivities")) { long id =
		 * esgDetailsDelegateUserModel.getTxtactivitiesdelegateuser();
		 * esgDetailTemp.setDelegateTo(userrepository.getOne(id));
		 * esgDetailRepository.saveAndFlush(esgDetailTemp); } if
		 * (esgDetailTemp.getEsgDetailText().equals("txtheadquarters")) { long id =
		 * esgDetailsDelegateUserModel.getTxtheadquartersdelegateuser();
		 * esgDetailTemp.setDelegateTo(userrepository.getOne(id));
		 * esgDetailRepository.saveAndFlush(esgDetailTemp); } if
		 * (esgDetailTemp.getEsgDetailText().equals("txtoperations")) { long id =
		 * esgDetailsDelegateUserModel.getTxtoperationsdelegateuser();
		 * esgDetailTemp.setDelegateTo(userrepository.getOne(id));
		 * esgDetailRepository.saveAndFlush(esgDetailTemp); } return true; }
		 * 
		 * catch (Exception e) { return false; } }
		 */

		if (response > 0 && txtactivities > 0 && txtheadquarters > 0 && responsetxtoperations > 0) {
			return true;
		} else {
			return false;
		}
	}
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "D:\\j\\";
        List<EsgDetail> esgDetail = esgDetailRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:esgdetails.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(esgDetail);
        Map<String, Object> parameters = new HashMap<>();
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\esg.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\esg.pdf");
        }

        return "report generated in path : " + path;
    }
}
