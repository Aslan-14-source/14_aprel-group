package accessModifiers.other;

public class Electronic extends Product {

	public Electronic(String name, double price) {
		super(name, price);
	}

	@Override
	public double calculateDiscount() {
		price = price - (price * 0.20);
		System.out.println(name + " discounted price: " + price);
		return price;
	}
}
