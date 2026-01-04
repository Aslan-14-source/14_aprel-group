package Src;

public class Main {
	public static void main(String[] args) {

		Animal animal = new Animal("Heyvan", 4);
		System.out.println("=== Animal Obyekti ===");
		animal.showAll();

		System.out.println();

		Cat cat = new Cat("Mestan", 2, "Qara");
		System.out.println("=== Cat Obyekti ===");
		cat.showAll(); // OVERRIDE olunmuş metod
	}
}
