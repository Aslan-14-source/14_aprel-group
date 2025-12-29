package main;

public class Person {

	protected int id;
	protected String name;
	protected String surname;
	protected int age;
	protected String phone;
	protected String address;

	public void printInfo() {
		System.out.println("ID: " + id);
		System.out.println("Ad: " + name);
		System.out.println("Soyad: " + surname);
		System.out.println("Yaş: " + age);
		System.out.println("Telefon: " + phone);
		System.out.println("Ünvan: " + address);
	}
}
