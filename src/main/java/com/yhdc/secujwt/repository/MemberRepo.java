package com.yhdc.secujwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.secujwt.model.Member;

public interface MemberRepo extends JpaRepository<Member, Long> {

	Member findByUsername(String username);
	
}
