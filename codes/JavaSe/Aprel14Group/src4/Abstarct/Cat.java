package Abstarct;

public class Cat extends Lion {

	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeNoise() {
		System.out.println("Cat: Meow Meow");
	}
}
