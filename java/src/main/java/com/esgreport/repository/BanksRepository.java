package com.esgreport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.Banks;

@Repository
public interface BanksRepository extends JpaRepository<Banks, Long> {
	Optional<Banks> findByName(String bankName);
}
