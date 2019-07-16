package com.mho.portfolio.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainContoller {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String Hello() {
		return "index";
	}

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String Hello(Model model) {
		model.addAttribute("name", "옴ㅇ학");
		return "index";
	}
}
