package Abstarct;

public class Dog extends Lion {

	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeNoise() {
		System.out.println("Dog: Woof Woof");
	}
}
