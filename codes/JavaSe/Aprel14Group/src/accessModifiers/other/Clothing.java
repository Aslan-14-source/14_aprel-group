package accessModifiers.other;

public class Clothing extends Product {

	public Clothing(String name, double price) {
		super(name, price);
	}

	@Override
	public double calculateDiscount() {
		price = price - (price * 0.15);
		System.out.println(name + " discounted price: " + price);
		return price;
	}
}
