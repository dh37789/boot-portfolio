package com.mho.portfolio.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.advice.exception.CUserNotFoundException;import com.mho.portfolio.config.security.JwtTokenProvider;
import com.mho.portfolio.domain.User;
import com.mho.portfolio.model.response.ListResult;
import com.mho.portfolio.model.response.SingleResult;
import com.mho.portfolio.service.ResponseService;
import com.mho.portfolio.service.UserService;

@RestController
@RequestMapping(value="/restUser")
public class UserController {

	private final UserService userService;
	private final ResponseService responseService;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
	
	public UserController(UserService userService, ResponseService responseService,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		this.userService = userService;
		this.responseService = responseService;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@GetMapping(value="/users")
	public ListResult<User> findAllUser(){
		return responseService.getListResult(userService.getAll());
	}
	
	@GetMapping(value="/user")
	public SingleResult<User> findUserById(@RequestParam String user_mail){
		return responseService.getSingleResult(userService.findById(user_mail).orElseThrow(CUserNotFoundException::new));
	}
	
	@PostMapping(value = "/login")
	public SingleResult<String> login(@RequestParam String user_mail, @RequestParam String user_pass){
		User user = userService.findById(user_mail).orElseThrow(CUserNotFoundException::new);
		String dd = passwordEncoder.encode(user_pass);
 		if (!passwordEncoder.matches(user_pass, user.getPassword()))
			throw new CUserNotFoundException();
		return responseService.getSingleResult(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
	}
	
}
