package com.mho.portfolio.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {
	@Autowired
	MainMapper mainDao;
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		return "index";
	}
}
