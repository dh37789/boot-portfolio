package com.mho.portfolio.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String hime() {
		return "Jello World!";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "This is admin page";
	}
	
	@RequestMapping("/usera")
	public String user() {
		return "This is user page";
	}
}
