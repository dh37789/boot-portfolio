package com.mho.portfolio.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody UserResponse get(@PathVariable(value="id") String id) {
		List<String> errors = new ArrayList<>();
		User user = null;
		try {
			user = userService.get(id);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return UserAdapter.userResponse(user, errors);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<UserResponse> getAll() {
		List<String> errors = new ArrayList<>();
		List<User> users = userService.getAll();
		List<UserResponse> userResponses = new ArrayList<>();
		users.stream().forEach(user -> {
			userResponses.add(UserAdapter.userResponse(user, errors));
		});
		return userResponses;
	}
//	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody UserResponse save(User user) {
		List<String> errors = new ArrayList<>();
//		User user = UserAdapter.userItem(userRequest);
//		try {
			user = userService.save(user);
//		} catch (final Exception e) {
//			errors.add(e.getMessage());
//		}
		return UserAdapter.userResponse(user, errors);
	}
}
