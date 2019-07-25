package com.mho.portfolio.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mho.portfolio.authority.AuthorityService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthenticationManager authenticationManager;

	
	public User get(final String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User save(final User user) {
		if (user == null) {
			throw new NullPointerException("회원정보를 입력할 수 없습니다.");
		}
		return userRepository.save(user);
	}
	
	public List<User> getAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public void createUser(User user) {
//		String rawPassword = user.getUser_pass();
//		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
//		user.setUser_pass(encodedPassword);
//		userRepository.save(user);
	}

	@Override
	public void login(User user) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUser_mail());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
		 = new UsernamePasswordAuthenticationToken(userDetails, user.getUser_pass(), userDetails.getAuthorities());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			System.out.println("인증성공");
		}
	}
}
