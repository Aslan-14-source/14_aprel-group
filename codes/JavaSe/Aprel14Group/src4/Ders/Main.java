package Ders;

public class Main {
	public static void main(String[] args) {

		Player original = new Player("Aslan", 100);

		Player clone = new Player(original.name, original.score);

		System.out.println("Original hashCode: " + original.hashCode());
		System.out.println("Clone hashCode: " + clone.hashCode());

		System.out.println("== ilə: " + (original == clone));

		System.out.println("equals ilə: " + original.equals(clone));

		System.out.println("original Player-dir? " + (original instanceof Player));

		System.out.println(original);
		System.out.println(clone);
	}
}
