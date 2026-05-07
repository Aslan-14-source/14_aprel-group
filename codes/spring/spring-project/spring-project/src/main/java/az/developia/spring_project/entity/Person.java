package az.developia.spring_project.entity;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Person {

	private int id;
	private String name;
	private int age;
	private double salary;

	public Person() {
		this.id = 1;
		this.name = "Aslan";
		this.age = 15;
		this.salary = 3000.0;
	}

	@PostConstruct
	public void init() {
		System.out.println("init method cagirildi");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy method cagirildi");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}