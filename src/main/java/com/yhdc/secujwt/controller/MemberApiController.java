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

import com.yhdc.secujwt.model.Member;
import com.yhdc.secujwt.model.RoleType;
import com.yhdc.secujwt.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberApiController {

	private final MemberService memberService;

	@GetMapping("/users")
	public ResponseEntity<List<Member>> getUsers() {

		List<Member> members = memberService.getUsers();

		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	@GetMapping("/user/get")
	public ResponseEntity<Member> getUser(@PathVariable String username) {

		Member member = memberService.getUser(username);

		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@PostMapping("/user/save")
	public ResponseEntity<Member> saveUser(@RequestBody Member newUser) {

		Member member = memberService.saveUser(newUser);

		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@PostMapping("/user/saverole")
	public ResponseEntity<String> addRoleToUser(@PathVariable String username, @PathVariable String roleName) {
		
		switch (roleName) {
		case "user":			
			memberService.addRoleToUser(username, RoleType.ROLE_USER);
			break;
			
		case "manager":			
			memberService.addRoleToUser(username, RoleType.ROLE_MANAGER);
			break;
			
		case "admin":			
			memberService.addRoleToUser(username, RoleType.ROLE_ADMIN);
			break;

		default:
			return new ResponseEntity<String>("UNKNOWN ROLE TYPE", HttpStatus.INTERNAL_SERVER_ERROR);			
		}		

		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

}
