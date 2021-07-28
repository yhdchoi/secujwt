package com.yhdc.secujwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yhdc.secujwt.model.Member;
import com.yhdc.secujwt.repository.MemberRepo;
import com.yhdc.secujwt.security.JwtProperties;
import com.yhdc.secujwt.service.auth.PrincipalDetails;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private MemberRepo memberRepo;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, MemberRepo memberRepo) {
		super(authenticationManager);
		this.memberRepo = memberRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String jwtHeader = request.getHeader(JwtProperties.HEADER_STRING);

		if (jwtHeader == null || !jwtHeader.startsWith(JwtProperties.HEADER_STRING)) {
			chain.doFilter(request, response);
			return;
		}

		String jwtToken = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");

		String username = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken)
				.getClaim("username").asString();

		if (username != null) {
			Member memberEntity = memberRepo.findByUsername(username);

			PrincipalDetails principalDetails = new PrincipalDetails(memberEntity);
			Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null,
					principalDetails.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);

			chain.doFilter(request, response);

		}

	}

}
