package com.mho.portfolio.authority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
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
