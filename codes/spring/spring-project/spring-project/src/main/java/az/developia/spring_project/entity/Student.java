package az.developia.spring_project.entity;

public class Student {

	private String name;
	private String surname;
	private int grade;

	public Student() {

	}

	public Student(String name, String surname, int grade) {
		this.name = name;
		this.surname = surname;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}