package com.esgreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esgreport.entity.Bank;
import com.esgreport.entity.EsgdetailsUserStatus;

public interface EsgDetailsUserStatusRepository extends JpaRepository<EsgdetailsUserStatus, Long>{

}
