
package az.developia.userservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.userservice.entity.User;
import az.developia.userservice.response.UserWithComputersResponse;
import az.developia.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}/computers")
	public UserWithComputersResponse getUserWithComputers(@PathVariable Long userId) {

		return userService.getUserWithComputers(userId);
	}
}
