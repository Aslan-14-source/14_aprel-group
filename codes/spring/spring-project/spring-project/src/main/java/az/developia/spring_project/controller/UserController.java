package az.developia.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project.entity.User;
import az.developia.spring_project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}