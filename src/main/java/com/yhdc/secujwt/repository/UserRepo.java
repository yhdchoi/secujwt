package com.yhdc.secujwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.secujwt.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
