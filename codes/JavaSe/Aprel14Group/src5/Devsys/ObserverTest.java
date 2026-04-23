package Devsys;

import java.util.ArrayList;
import java.util.List;

class Student {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public void update(String message) {
		System.out.println(name + " received announcement: " + message);
	}
}

class School {
	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public void announce(String message) {
		for (Student s : students) {	
			s.update(message);
		}
	}
}

public class ObserverTest {
	public static void main(String[] args) {
		School school = new School();

		Student s1 = new Student("Aslan");
		Student s2 = new Student("Nigar");

		school.addStudent(s1);
		school.addStudent(s2);

		school.announce("Tomorrow is holiday!");
	}
}