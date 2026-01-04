package accessModifiers.other;

public class Main {
	public static void main(String[] args) {

		Product product = new Product("Generic Product", 100);
		product.calculateDiscount();

		Electronic electronic = new Electronic("Laptop", 2000);
		electronic.calculateDiscount();

		Clothing clothing = new Clothing("Car", 200);
		clothing.calculateDiscount();
	}
}
