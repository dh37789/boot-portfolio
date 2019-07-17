package com.mho.portfolio.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainContoller {
	@Autowired
	MainMapper mainDao;
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public @ResponseBody String hello(Model model) {
		MainVO vo = mainDao.findMain();
		return vo.getId();
	}
}
