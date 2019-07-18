package com.mho.portfolio.user;

import java.util.List;
import com.mho.portfolio.apiResponse.ApiResponse;
import lombok.Builder;

public class UserResponse extends ApiResponse<User> {
	
	@Builder
	public UserResponse(final User user, final List<String> errors) {
		super(user);
		this.setErrors(errors);
	}
}
