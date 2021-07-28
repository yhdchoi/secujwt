package com.yhdc.secujwt.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yhdc.secujwt.model.Member;
import com.yhdc.secujwt.repository.MemberRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	
	private final MemberRepo memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Member memberEntity = memberRepo.findByUsername(username);		
		
		return new PrincipalDetails(memberEntity);
	}
	
}
