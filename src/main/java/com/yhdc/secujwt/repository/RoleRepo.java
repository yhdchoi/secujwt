package com.yhdc.secujwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.secujwt.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName(String role);

}
