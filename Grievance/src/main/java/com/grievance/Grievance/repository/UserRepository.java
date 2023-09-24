package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByEmail(String email);

	boolean existsByEmailAndPassword(String email, String password);

	boolean existsByEmailAndPasswordAndUsertype(String email, String password, UserType admin);

}