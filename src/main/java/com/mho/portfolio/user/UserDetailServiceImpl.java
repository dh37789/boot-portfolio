package com.mho.portfolio.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mho.portfolio.authority.Authority;

@Component
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElse(null);
		Set<GrantedAuthority> grantAuthorities = new HashSet<>();
		for (Authority authority : user.getAuthorities()) {
			grantAuthorities.add(new SimpleGrantedAuthority(authority.getAuth_name()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUser_mail(), 
																	  user.getUser_pass(), 
																	  grantAuthorities);
	}

}
