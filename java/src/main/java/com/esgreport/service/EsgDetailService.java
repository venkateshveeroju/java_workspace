package com.esgreport.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esgreport.entity.EsgDetail;
import com.esgreport.entity.User;
import com.esgreport.model.EsgDetailModel;
import com.esgreport.payload.response.MessageResponse;
import com.esgreport.repository.EsgDetailRepository;

@Service
public class EsgDetailService {
	
	private EsgDetail esgDetail;


	private User user;

	@Autowired
	private EsgDetailRepository esgDetailRepository;

	// private static final Logger LOGGER =
	// Logger.getLogger(EsgDetailService.class.getName());

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

	public MessageResponse save(EsgDetailModel esgDetailModel) {
		if (esgDetailModel == null) {
			return null;
		}
//		Field[] fields = esgDetailModel.getClass().getDeclaredFields();
//		  System.out.printf("%d fields:%n", fields.length);
//		for (Field field : fields) {
//			System.out.println(field);
//			 esgDetail = new EsgDetail ();
//			//esgDetail.setEsgDetailsText();
//			//esgDetail.setBank(user.getBank().getBankName());
//			// esgDetail.setDelegateTo(delegateTo);
//			esgDetail.setLastModifiedDate(new Date());
//		esgDetail.setLastModifiedBy(user);
//
//			//esgDetailRepository.save(esgDetail);
//			return new MessageResponse("Saved successfully");
//		}
		return null;
	}
}
