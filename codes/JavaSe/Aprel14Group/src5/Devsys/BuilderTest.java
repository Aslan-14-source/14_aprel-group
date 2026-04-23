package Devsys;

class Car {
	private String brand;
	private String model;
	private int year;
	private String color;

	private Car(CarBuilder builder) {
		this.brand = builder.brand;
		this.model = builder.model;
		this.year = builder.year;
		this.color = builder.color;
	}

	public void showInfo() {
		System.out.println(year + " " + brand + " " + model + " in " + color);
	}

	public static class CarBuilder {
		private String brand;
		private String model;
		private int year;
		private String color;

		public CarBuilder setBrand(String brand) {
			this.brand = brand;
			return this;
		}

		public CarBuilder setModel(String model) {
			this.model = model;
			return this;
		}

		public CarBuilder setYear(int year) {
			this.year = year;
			return this;
		}

		public CarBuilder setColor(String color) {
			this.color = color;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}

public class BuilderTest {
	public static void main(String[] args) {
		Car car = new Car.CarBuilder().setBrand("BMW").setModel("X5").setYear(2022).setColor("Black").build();

		car.showInfo();
	}
}