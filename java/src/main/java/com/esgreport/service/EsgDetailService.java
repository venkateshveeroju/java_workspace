package com.esgreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esgreport.entity.EsgDetail;
import com.esgreport.repository.EsgDetailRepository;

@Service
public class EsgDetailService {

	private EsgDetail esgDetail;

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

	public void delete(EsgDetail esgDetail) {
		esgDetailRepository.delete(esgDetail);
	}

	public void save(EsgDetail esgDetail) {
		if (esgDetail == null) {

			return;
		}
		esgDetailRepository.save(esgDetail);
	}

}
