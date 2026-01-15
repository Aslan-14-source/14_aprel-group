package Abstarct;

public class Main {
	public static void main(String[] args) {

		Animal a = new Animal("Generic", 5);
		Cat c = new Cat("Mestan", 2);
		Dog d = new Dog("Toplan", 3);

		a.makeNoise();
		c.makeNoise();
		d.makeNoise();
	}
}