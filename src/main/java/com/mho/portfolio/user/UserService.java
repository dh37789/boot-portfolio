package com.mho.portfolio.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService{
	
	public User get(final String id);
	
	public User save(final User user);
	
	public List<User> getAll();
}
