package com.mho.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.advice.exception.CUserNotFoundException;
import com.mho.portfolio.domain.User;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.model.response.SingleResult;
import com.mho.portfolio.service.ResponseService;
import com.mho.portfolio.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	private final UserService userService;
	private final ResponseService responseService;
	
	public UserController(UserService userService, ResponseService responseService) {
		this.userService = userService;
		this.responseService = responseService;
	}
	
	@GetMapping(value="/user")
	public ListResult<User> findAllUser(){
		return responseService.getListResult(userService.getAll());
	}
	
	@GetMapping(value="/{user_id}")
	public SingleResult<User> findUserById(@PathVariable String user_id){
		return responseService.getSingleResult(userService.findById(user_id).orElseThrow(CUserNotFoundException::new));
	}
	
}
