package com.mho.portfolio.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody User get(@PathVariable(value="id") String id) {
		User user = null;
		try {
			user = userService.get(id);
		} catch (final Exception e) {
			e.getMessage();
		}
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getAll() {
		List<User> users = userService.getAll();
		return users;
	}
//	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User save(User user) {
		List<String> errors = new ArrayList<>();
//		User user = UserAdapter.userItem(userRequest);
//		try {
			user = userService.save(user);
//		} catch (final Exception e) {
//			errors.add(e.getMessage());
//		}
		return user;
	}
}
