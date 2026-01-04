package Src;

public class Animal {
	protected String name;
	protected int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showAll() {
		System.out.println("Ad: " + name);
		System.out.println("Yaş: " + age);
	}
}
