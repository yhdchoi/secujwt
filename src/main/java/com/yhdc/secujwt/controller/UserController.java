package com.yhdc.secujwt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.secujwt.model.Role;
import com.yhdc.secujwt.model.User;
import com.yhdc.secujwt.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

	private final UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = userServiceImpl.getUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/user/get")
	public ResponseEntity<User> getUser(@PathVariable String username) {

		User user = userServiceImpl.getUser(username);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User newUser) {

		User user = userServiceImpl.saveUser(newUser);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role newRole) {

		Role role = userServiceImpl.saveRole(newRole);

		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

	@PostMapping("/role/save")
	public ResponseEntity<String> addRoleToUser(@PathVariable String username, @PathVariable String roleName) {

		userServiceImpl.addRoleToUser(username, roleName);

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

}
