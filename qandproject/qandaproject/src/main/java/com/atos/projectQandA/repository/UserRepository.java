package com.atos.projectQandA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.projectQandA.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
 
}
