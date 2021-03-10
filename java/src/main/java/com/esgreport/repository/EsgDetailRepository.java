package com.esgreport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.EsgDetail;

@Repository
public interface EsgDetailRepository extends JpaRepository<EsgDetail, Long>{
	Optional<EsgDetail> findById(Long id);
	EsgDetail findByesgDetailText(String esgdetailtext);
	
	@Modifying
	@Query("update EsgDetail set delegate_to = ?1 where esg_detail_text = ?2")
	int updateDelegate(int delegate_to, String esg_detail_text);
}
