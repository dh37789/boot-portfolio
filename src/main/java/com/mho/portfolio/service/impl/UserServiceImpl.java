package com.mho.portfolio.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mho.portfolio.advice.exception.CUserNotFoundException;
import com.mho.portfolio.domain.User;
import com.mho.portfolio.repository.UserRepository;
import com.mho.portfolio.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
    	this.userRepository = userRepository;
	}
    
	
	public List<User> getAll() {
		return (List<User>)userRepository.findAll();
	}
	
	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	@Override
	public Optional<User> findById(String user_mail) {
		Optional<User> user = userRepository.findById(user_mail);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findById(username).orElseThrow(CUserNotFoundException::new);
	}
}
