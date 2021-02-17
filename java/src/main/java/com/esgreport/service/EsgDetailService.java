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
import com.fasterxml.jackson.core.sym.Name;

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
	private EsgDetailsUserStatusRepository esgDetailsUserStatusRepository;
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

		System.out.println(esgDetailModel.getTxtactivities());
		System.out.println(esgDetailModel.getTxtactivitiesesgdetailsuserstatusid());

		///// -------------------------------
		esgdetail = new EsgDetail();
		esgdetail = (EsgDetail) esgDetailRepository.findByesgDetailText("txtactivities");

		bank = bankrepository.getOne((long) esgDetailModel.getTxtactivitiesmodelbankid());
		user = userrepository.getOne((long) esgDetailModel.getTxtactivitiesmodellastmodifiedby());
		EsgDetailsModeratorStatus esgdetailsmoderatorstatus1 = esgdetailsmoderatorstatusrepository
				.getOne((long) esgDetailModel.getTxtactivitiesmodellastmodifiedby());
		EsgdetailsUserStatus esgdetailsuserstatus1 = esgdetailsuserstatusrepository
				.getOne((long) esgDetailModel.getTxtactivitiesesgdetailsuserstatusid());

		esgdetail.setEsgDetailTextValue(esgDetailModel.getTxtactivities());
		esgdetail.setLastModifiedBy(userrepository.getOne((long) esgDetailModel.getTxtactivitiesmodellastmodifiedby()));

		esgdetail.setModeratorStatusId(esgdetailsmoderatorstatus1);
		esgdetailsuserstatus1 = esgDetailsUserStatusRepository
				.getOne((Long) esgDetailModel.getTxtactivitiesesgdetailsuserstatusid());
		esgdetail.setUserStatusId(esgdetailsuserstatus1);
		esgdetail.setLastModifiedDate(new Date());
		esgdetail.setBank(bank);
		esgDetailRepository.saveAndFlush(esgdetail);
/////////////////////////
		/*
		esgdetail = new EsgDetail();
		esgdetail = (EsgDetail) esgDetailRepository.findByesgDetailText("txtheadquarters");

		bank = bankrepository.getOne((long) esgDetailModel.getTxtheadquartersmodelbankid());
		user = userrepository.getOne((long) esgDetailModel.getTxtheadquartersesgdetailsuserstatusid());
		EsgDetailsModeratorStatus esgdetailsmoderatorstatus = esgdetailsmoderatorstatusrepository
				.getOne((long) esgDetailModel.getTxtheadquartersmodellastmodifiedby());
		EsgdetailsUserStatus esgdetailsuserstatus = esgdetailsuserstatusrepository
				.getOne((long) esgDetailModel.getTxtheadquartersesgdetailsuserstatusid());

		esgdetail.setEsgDetailTextValue(esgDetailModel.getTxtactivities());
		esgdetail.setLastModifiedBy(userrepository.getOne((long) esgDetailModel.getTxtheadquartersmodellastmodifiedby()));

		esgdetail.setModeratorStatusId(esgdetailsmoderatorstatus);
		esgdetailsuserstatus = esgDetailsUserStatusRepository
				.getOne((Long) esgDetailModel.getTxtheadquartersesgdetailsuserstatusid());
		esgdetail.setUserStatusId(esgdetailsuserstatus);
		esgdetail.setLastModifiedDate(new Date());
		esgdetail.setBank(bank);
*/
		///// -------------------------------

		// System.out.println(esgDetailModel.getTxtoperations());
		/*
		 * { "txtactivities": "activities", "txtactivitiesmodelbankid": "1111",
		 * "txtactivitiesmodellastmodifiedby": "1111",
		 * "txtactivitiesesgdetailsuserstatusid": "1111", "txtheadquarters":
		 * "frankfurt", "txtheadquartersmodelbankid": "222222",
		 * "txtheadquartersmodellastmodifiedby": "222222",
		 * "txtheadquartersesgdetailsuserstatusid": "222222", "txtoperations":
		 * "banking", "txtoperationsmodelbankid": "33333",
		 * "txtoperationsmodellastmodifiedby": "33333",
		 * "txtoperationsesgdetailsuserstatusid": "33333", "txtorganization":
		 * "commerzbank", "txtorganizationmodelbankid": "44444",
		 * "txtorganizationmodellastmodifiedby": "44444",
		 * "txtorganizationesgdetailsuserstatusid": "44444"
		 * 
		 * }
		 */

		/*
		 * for (Field field : fields) { field.setAccessible(true);
		 * System.out.println(field.get(esgDetailModel).toString());
		 * System.out.println(field.get("txtactivitiesmodellastmodifiedby"));
		 * System.out.println("aaaaaaaaaaaaaaa");
		 * 
		 * esgdetail = new EsgDetail(); esgdetail = (EsgDetail)
		 * esgDetailRepository.findByesgDetailText(field.getName()); //
		 * System.out.println((EsgDetail) //
		 * esgDetailRepository.findByesgDetailText(field.getName())); bank =
		 * bankrepository.getOne((long) 1); user = userrepository.getOne((long) 1);
		 * EsgDetailsModeratorStatus esgdetailsmoderatorstatus =
		 * esgdetailsmoderatorstatusrepository.getOne((long) 1); EsgdetailsUserStatus
		 * esgdetailsuserstatus = esgdetailsuserstatusrepository.getOne((long) 1);
		 * 
		 * if (field.getName().equals("txtactivities") &&
		 * field.getType().equals(String.class)) {
		 * 
		 * System.out.println(userrepository.getOne((long)
		 * field.get(esgDetailModel.getTxtactivitiesmodellastmodifiedby())));
		 * System.out.println("dasfadfadf ---------" +
		 * field.get(esgDetailModel).toString());
		 * esgdetail.setEsgDetailTextValue(field.get(esgDetailModel).toString());
		 * esgdetail.setLastModifiedBy(userrepository.getOne((long)
		 * field.get(esgDetailModel.getTxtactivitiesmodellastmodifiedby())));
		 * 
		 * esgdetail.setModeratorStatusId(esgdetailsmoderatorstatus);
		 * esgdetailsuserstatus =esgDetailsUserStatusRepository.getOne((Long)
		 * field.get(esgDetailModel.getTxtactivitiesesgdetailsuserstatusid()));
		 * esgdetail.setUserStatusId(esgdetailsuserstatus);
		 * //esgdetail.setUserStatusId(field.get(esgDetailModel)); }
		 * System.out.println("dasfadfadf ---------" + field.get(esgDetailModel));
		 * 
		 * // esgdetail.setLastModifiedDate(new Date());
		 * 
		 * esgdetail.setBank(bank);
		 * 
		 * 
		 * esgDetailRepository.saveAndFlush(esgdetail);
		 */

		return new MessageResponse("Saved successfully");
	}
}
