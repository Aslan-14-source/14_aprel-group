import java.util.*;

class Product {
	String name;
	int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

public class Task {
	public static void main(String[] args) {

		List<Product> products = Arrays.asList(new Product("Telefon", 80), new Product("Noutbuk", 120),
				new Product("Mouse", 40), new Product("Monitor", 90), new Product("Klaviatura", 50));

		String result = products.stream().filter(p -> p.price > 60)
				.map(p -> p.name)
				.sorted()
				.reduce("", (a, b) -> a + (a.isEmpty() ? "" : " ") + b);

		System.out.println(result);
	}
}