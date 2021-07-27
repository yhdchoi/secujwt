package com.yhdc.secujwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeApiController {

	@GetMapping("")
	public String home() {
		return "<h1>Home</h1>";
	}
}
