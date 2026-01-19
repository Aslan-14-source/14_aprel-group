package Abstarct;

public class Toy {

	String name;
	double price;

	public Toy(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[Oyuncaq: " + name + ", Qiymət: " + price + " AZN]";
	}

	@Override
	public boolean equals(Object obj) {
		Toy that = (Toy) obj;

		if (this.name.equals(that.name) && this.price == that.price) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Toy toy1 = new Toy("Maşın", 10);
		System.out.println(toy1);

		Toy toy2 = new Toy("Top", 5);
		Toy toy3 = new Toy("Top", 5);

		System.out.println(toy2.equals(toy3)); // true
	}
}
