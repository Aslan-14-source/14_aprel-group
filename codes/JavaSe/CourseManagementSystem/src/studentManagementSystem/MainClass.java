package studentManagementSystem;

import studentManagementSystem.entity.Student;
import studentManagementSystem.repository.StudentRepository;

public class MainClass {

	public static void main(String[] args) {

		Student student = new Student("Ali", "Mammadov", 20);

		StudentRepository repository = new StudentRepository();

		repository.addStudent(student);

	}

}