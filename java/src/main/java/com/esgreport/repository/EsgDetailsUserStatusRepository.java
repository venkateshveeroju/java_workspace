package com.esgreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esgreport.entity.Bank;
import com.esgreport.entity.EsgDetailsUserStatus;

public interface EsgDetailsUserStatusRepository extends JpaRepository<EsgDetailsUserStatus, Long>{

}
