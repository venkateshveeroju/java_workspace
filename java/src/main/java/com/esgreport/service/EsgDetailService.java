package com.esgreport.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esgreport.entity.Bank;
import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.EsgDetailsModeratorStatus;
import com.esgreport.entity.EsgdetailsUserStatus;
import com.esgreport.entity.User;
import com.esgreport.model.EsgDetailModel;
import com.esgreport.payload.response.MessageResponse;
import com.esgreport.repository.BankRepository;
import com.esgreport.repository.EsgDetailRepository;
import com.esgreport.repository.EsgDetailsModeratorStatusRepository;
import com.esgreport.repository.EsgDetailsUserStatusRepository;
import com.esgreport.repository.UserRepository;

@Service
public class EsgDetailService {

	private EsgDetail esgdetail;
	private User user;
	private Bank bank;
	private EsgdetailsUserStatus esgdetailsuserstatus;
	private EsgDetailsModeratorStatus esgdetailsmoderatorstatus;

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

	public MessageResponse save(EsgDetailModel esgDetailModel) throws IllegalArgumentException, IllegalAccessException {
		if (esgDetailModel == null) {
			return null;
		}
		System.out.println(esgDetailModel.toString());
		Field[] fields = esgDetailModel.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println("field  "+field.getLong(esgDetailModel));
			//System.out.println(field.get(esgDetailModel).toString());
			
			esgdetail = new EsgDetail();
			esgdetail = (EsgDetail) esgDetailRepository.findByesgDetailText(field.getName());
			//System.out.println((EsgDetail) esgDetailRepository.findByesgDetailText(field.getName()));
			bank = bankrepository.getOne((long) 1);
			user = userrepository.getOne((long) 1);
			EsgDetailsModeratorStatus esgdetailsmoderatorstatus = esgdetailsmoderatorstatusrepository.getOne((long) 1);
			EsgdetailsUserStatus esgdetailsuserstatus = esgdetailsuserstatusrepository.getOne((long) 1);

		esgdetail.setEsgDetailTextValue(field.get(esgDetailModel).toString());
//			System.out.println("dasfadfadf ---------" + field.get(esgDetailModel).toString());
//if(field.getName().equals("txtheadquarters") && field.getType().equals(String.class)) {
//	
//
//			//System.out.println("dasfadfadf ---------" + field.get(esgDetailModel).toString());
//}
			esgdetail.setLastModifiedDate(new Date());

			esgdetail.setBank(bank);
			esgdetail.setLastModifiedBy(user);
		
			esgdetail.setModeratorStatusId(esgdetailsmoderatorstatus);
			esgdetail.setUserStatusId(esgdetailsuserstatus);

			esgDetailRepository.saveAndFlush(esgdetail);

		}
		return new MessageResponse("Saved successfully");
	}
}
