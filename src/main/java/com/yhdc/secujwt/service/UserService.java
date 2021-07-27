package com.yhdc.secujwt.service;

import java.util.List;

import com.yhdc.secujwt.model.Role;
import com.yhdc.secujwt.model.User;

public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
