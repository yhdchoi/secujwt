package com.yhdc.secujwt.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yhdc.secujwt.filter.SecuFilter2;
import com.yhdc.secujwt.filter.SecuFilter3;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<SecuFilter2> filter2() {

		FilterRegistrationBean<SecuFilter2> bean = new FilterRegistrationBean<>(new SecuFilter2());

		bean.addUrlPatterns("/*");
		bean.setOrder(0);

		return bean;
	}

	@Bean
	public FilterRegistrationBean<SecuFilter3> filter3() {

		FilterRegistrationBean<SecuFilter3> bean = new FilterRegistrationBean<>(new SecuFilter3());

		bean.addUrlPatterns("/*");
		bean.setOrder(1);

		return bean;
	}
}
