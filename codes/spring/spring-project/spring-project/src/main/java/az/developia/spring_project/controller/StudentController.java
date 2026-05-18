package az.developia.spring_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.spring_project.entity.Student;

@Controller
public class StudentController {

	List<Student> students = new ArrayList<Student>(
			List.of(new Student("James", "Brown", 6), new Student("John", "Smith", 7)));

	@GetMapping(path = "/students")
	public String getStudents(Model model) {

		model.addAttribute("students", students);

		return "students";
	}
}