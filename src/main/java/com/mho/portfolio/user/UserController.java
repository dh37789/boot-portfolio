package com.mho.portfolio.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import com.mho.portfolio.authority.AuthenticationToken;

//@RestController
//@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	
	public UserController(UserService userService, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody User get(@PathVariable(value="id") String id) {
		User user = null;
		try {
			user = userService.get(id);
		} catch (final Exception e) {
			e.getMessage();
		}
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getAll() {
		List<User> users = userService.getAll();
		return users;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/auth")
	public @ResponseBody UserDetails auth(User user) {
		UserDetails userDetails = userService.loadUserByUsername(user.getUser_mail());
		return userDetails;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/login")
	public AuthenticationToken login(@RequestBody User user,
									 HttpSession session) {
		String username = user.getUser_mail();
		String password = user.getUser_pass();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
					SecurityContextHolder.getContext());
		
		user = userService.get(username);
		return new AuthenticationToken(user.getUser_mail(), user.getAuthorities(), session.getId());
		
	}
}
