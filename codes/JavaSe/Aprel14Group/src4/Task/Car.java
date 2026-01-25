package Task;

public class Car implements Cloneable {
	String model;
	String brand;

	public Car(String model, String brand) {
		this.model = model;
		this.brand = brand;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
