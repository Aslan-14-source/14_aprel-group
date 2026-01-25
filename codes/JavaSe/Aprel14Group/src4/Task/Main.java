package Task;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {

		Car car1 = new Car("Camry", "Toyota");

		// obyektin ünvanı (hashCode)
		System.out.println(car1.hashCode());

		// obyektin kopiyası
		Car car2 = (Car) car1.clone();

		System.out.println(car2.hashCode());
	}
}
