package com.yhdc.secujwt.repotest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yhdc.secujwt.model.Member;
import com.yhdc.secujwt.model.RoleType;
import com.yhdc.secujwt.repository.MemberRepo;

@SpringBootTest
public class MemberRepoTest {

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	public void insert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {

			Member member = Member.builder().name("Name" + i).username("USER" + i).password(bCryptPasswordEncoder.encode("password"))
					.role(RoleType.ROLE_USER).build();

			memberRepo.save(member);
		});
	}

	@Test
	public void insertManager() {
		IntStream.rangeClosed(1, 3).forEach(i -> {

			Member member = Member.builder().name("Manager" + i).username("Manager" + i).password(bCryptPasswordEncoder.encode("password"))
					.role(RoleType.ROLE_MANAGER).build();

			memberRepo.save(member);
		});
	}

	@Test
	public void insertAdmin() {
		IntStream.rangeClosed(1, 2).forEach(i -> {

			Member member = Member.builder().name("Admin" + i).username("Admin" + i).password(bCryptPasswordEncoder.encode("password"))
					.role(RoleType.ROLE_ADMIN).build();

			memberRepo.save(member);
		});
	}
}