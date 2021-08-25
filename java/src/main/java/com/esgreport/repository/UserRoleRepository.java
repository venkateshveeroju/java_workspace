package com.esgreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	@Query(value="select a.email from users a ,roles b where a.id = b.id and b.id=:id",nativeQuery = true)
    List<String> findModById(@Param("id") Long id);
}
