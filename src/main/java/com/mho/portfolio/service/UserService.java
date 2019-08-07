package com.mho.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mho.portfolio.domain.User;

public interface UserService extends UserDetailsService{
	public List<User> getAll();
	public PasswordEncoder passwordEncoder();
	public Optional<User> findById(String user_id);
}
