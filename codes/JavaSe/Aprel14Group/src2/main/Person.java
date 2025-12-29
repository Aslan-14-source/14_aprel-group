package main;

public class Person {
	protected int id;
	protected String name;
	protected String surname;
	protected int age;
	protected String phone;
	protected String address;

	public Person(int id, String name, String surname, int age, String phone, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public void printInfo() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Surname: " + surname);
		System.out.println("Age: " + age);
		System.out.println("Phone: " + phone);
		System.out.println("Address: " + address);
	}
}
