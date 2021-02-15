package com.esgreport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.EsgDetail;
import com.esgreport.model.EsgDetailModel;

@Repository
public interface EsgDetailRepository extends JpaRepository<EsgDetail, Long>{
	Optional<EsgDetail> findById(Long id);
	EsgDetail findByesgDetailText(String esgdetailtext);
	// void saveEsg(String esgDetail);
	 //void saveBankName(String bankName);

	//void save(EsgDetailModel esgDetailModel);
}
