package com.mho.portfolio.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mho.portfolio.advice.exception.CUserNotFoundException;
import com.mho.portfolio.config.security.JwtTokenProvider;
import com.mho.portfolio.domain.User;
import com.mho.portfolio.model.response.SingleResult;
import com.mho.portfolio.service.ResponseService;
import com.mho.portfolio.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final ResponseService responseService;
	private final JwtTokenProvider jwtTokenProvider;
	
	public LoginController(UserService userService, PasswordEncoder passwordEncoder, ResponseService responseService,
			JwtTokenProvider jwtTokenProvider) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.responseService = responseService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@PostMapping("signIn")
	public SingleResult<String> signIn(@RequestParam String user_id, @RequestParam String user_pass){
		User user = userService.findById(user_id).orElseThrow(CUserNotFoundException::new);
 		if (!passwordEncoder.matches(user_pass, user.getPassword()))
			throw new CUserNotFoundException();
		return responseService.getSingleResult(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
	}
	
}
