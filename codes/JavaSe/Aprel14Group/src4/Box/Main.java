package Box;

public class Main {
	public static void main(String[] args) {

		Box<Integer> intBox = new Box<>();
		intBox.set(100);
		System.out.println("Integer Box deyeri: " + intBox.get());

		Box<String> stringBox = new Box<>();
		stringBox.set("Salam Java");
		System.out.println("String Box deyeri: " + stringBox.get());

		Box<Double> doubleBox = new Box<>();
		doubleBox.set(45.7);
		System.out.println("Double Box deyeri: " + doubleBox.get());

		intBox.printAny("Test mesajı");
		intBox.printAny(999);
		intBox.printAny(12.34);
	}
}
