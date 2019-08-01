package com.mho.portfolio.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.mho.portfolio.repository.AuthorityRepository;
import com.mho.portfolio.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	private AuthorityRepository authorityRepository;
	
	public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<String> string_authorities = (List<String>) authorityRepository.findById(username).orElse(null);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(String authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority));
		}
		return authorities;
	}

}
