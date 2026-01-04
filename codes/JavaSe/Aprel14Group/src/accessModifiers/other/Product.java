package accessModifiers.other;

public class Product {
	String name;
	double price;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public double calculateDiscount() {
		price = price - (price * 0.10);
		System.out.println(name + " discounted price: " + price);
		return price;
	}
}
