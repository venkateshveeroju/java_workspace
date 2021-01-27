package com.esgreport.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.esgreport.entity.EsgDetail;

@Repository
public interface EsgDetailRepository {
	Optional<EsgDetail> findById(Long id);
}
