package com.yhdc.secujwt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.secujwt.model.RoleType;
import com.yhdc.secujwt.model.Member;
import com.yhdc.secujwt.repository.MemberRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Transactional
@Log4j2
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberRepo memberRepo;
	

	@Override
	public Member saveUser(Member member) {
		log.info("Saving new user {}", member.getName());
		return memberRepo.save(member);
	}

	@Override
	public void addRoleToUser(String username, RoleType roleName) {
		log.info("Adding role {} to user {}", roleName, username);

		Member member = memberRepo.findByUsername(username);

		member.setRole(roleName);
	}

	@Override
	public Member getUser(String username) {
		log.info("Fetching user {}", username);

		return memberRepo.findByUsername(username);
	}

	@Override
	public List<Member> getUsers() {
		log.info("Fetching all users");

		return memberRepo.findAll();
	}

	

}
