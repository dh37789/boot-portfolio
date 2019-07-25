package com.mho.portfolio.user;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService{
	public void login(User user);
	public User get(final String id);
	public User save(final User user);
	public List<User> getAll();
	public void createUser(User user);
	public PasswordEncoder passwordEncoder();
}
