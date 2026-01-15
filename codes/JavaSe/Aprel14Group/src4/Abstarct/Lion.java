package Abstarct;

public abstract class Lion {
	String name;
	int age;

	public Lion(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public abstract void makeNoise();
}
