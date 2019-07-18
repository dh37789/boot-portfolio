package com.mho.portfolio.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserAdapter {
	
	public static UserResponse userResponse(final User user, final List<String> errors) {
		return UserResponse.builder()
				.user(user)
				.errors(Optional.ofNullable(errors).orElse(new ArrayList<>()))
				.build();
	}

	public static User userItem(UserRequest userRequest) {
		if (userRequest == null) {
			return null;
		}
		return User.builder()
					.id(userRequest.getId())
					.pass(userRequest.getPass())
					.name(userRequest.getName())
					.build();
	}
	
	
}
