package az.developia.spring_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.ComputerShopping.entity.Computer;

@RestController
public class ComputerController {

	private List<Computer> computers = new ArrayList<>();

	@GetMapping("/computers")
	public List<Computer> getAllComputers() {
		return computers;
	}

	@PostMapping("/computers")
	public String addComputer(@RequestBody Computer computer) {

		computers.add(computer);

		System.out.println(computer);

		return "Computer added successfully";
	}
}