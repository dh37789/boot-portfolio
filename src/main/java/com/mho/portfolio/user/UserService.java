package com.mho.portfolio.user;

import java.util.List;

public interface UserService {
	
	public User get(final String id);
	
	public User save(final User user);
	
	public List<User> getAll();
}
