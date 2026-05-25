package az.developia.spring_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.spring_project.entity.Student;

@Controller
public class StudentController {

	List<Student> students = new ArrayList<>();

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("students", students);

		return "index";
	}

	@PostMapping("/add")
	public String addStudent(Student student) {

		students.add(student);

		return "redirect:/";
	}
}