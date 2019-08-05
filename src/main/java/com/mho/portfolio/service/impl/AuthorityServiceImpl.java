package com.mho.portfolio.service.impl;

import org.springframework.stereotype.Service;

import com.mho.portfolio.repository.AuthorityRepository;
import com.mho.portfolio.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	private AuthorityRepository authorityRepository;
	
	public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
}
