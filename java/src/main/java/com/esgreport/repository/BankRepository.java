package com.esgreport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
	//Optional<Banks> findByName(String bankName);
}
