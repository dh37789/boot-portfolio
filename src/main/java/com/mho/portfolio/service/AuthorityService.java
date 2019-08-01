package com.mho.portfolio.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface AuthorityService {
	
	public Collection<GrantedAuthority> getAuthorities(String username);
		
}
