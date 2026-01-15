package Abstarct;

public class Animal extends Lion {

	public Animal(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeNoise() {
		System.out.println("Animal səs çıxarır");
	}
}
