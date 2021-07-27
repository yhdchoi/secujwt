package com.yhdc.secujwt.service;

import java.util.List;

import com.yhdc.secujwt.model.RoleType;
import com.yhdc.secujwt.model.Member;

public interface MemberService {

	String saveUser(Member member);

	void addRoleToUser(String username, RoleType roleName);

	Member getUser(String username);

	List<Member> getUsers();
}
