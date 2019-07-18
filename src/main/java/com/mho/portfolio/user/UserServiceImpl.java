package com.mho.portfolio.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
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
}
