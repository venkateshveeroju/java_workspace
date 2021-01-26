package com.esgreport.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.esgreport.entity.Banks;

@Repository
public interface EsgDetailsRepository {
	Optional<Banks> findById(Long esgDetailsId);
}
