package com.yhdc.secujwt.security;

public interface JwtProperties {

	String SECRET = "AKIAUdK72JSUFOYCgKJ7";
	int EXPIRATION_DATE = 864000000; // 10days
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_STRING = "Authorization";
}
