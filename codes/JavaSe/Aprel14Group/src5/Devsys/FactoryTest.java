package Devsys;

class Car {
	public void move() {
		System.out.println("Car is moving...");
	}
}

class Bike {
	public void move() {
		System.out.println("Bike is moving...");
	}
}

class VehicleFactory {
	public Object createVehicle(String type) {
		if (type.equalsIgnoreCase("car")) {
			return new Car();
		} else if (type.equalsIgnoreCase("bike")) {
			return new Bike();
		}
		return null;
	}
}

public class FactoryTest {
	public static void main(String[] args) {
		VehicleFactory factory = new VehicleFactory();

		Car car = (Car) factory.createVehicle("car");
		car.move();

		Bike bike = (Bike) factory.createVehicle("bike");
		bike.move();
	}
}