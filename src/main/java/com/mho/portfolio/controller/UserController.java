package com.mho.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.service.ResponseService;
import com.mho.portfolio.user.User;
import com.mho.portfolio.user.UserRepository;
import com.mho.portfolio.user.UserService;

@RestController
@RequestMapping(value="/restUser")
public class UserController {

	private UserService userService;
	private ResponseService responseService;
	
	public UserController(UserService userService, ResponseService responseService) {
		this.userService = userService;
		this.responseService = responseService;
	}
	
	@GetMapping(value="/users")
	public ListResult<User> findAllUser(){
		return responseService.getListResult(userService.getAll());
	}
}
