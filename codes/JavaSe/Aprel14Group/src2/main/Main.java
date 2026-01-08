package main;

public class Main {
	public static void main(String[] args) {

		Circle circle = new Circle(5);
		Rectangle rectangle = new Rectangle(4, 6);

		System.out.println("Circle Area: " + circle.getArea());
		System.out.println("Circle Perimeter: " + circle.getPerimeter());

		System.out.println("Rectangle Area: " + rectangle.getArea());
		System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
	}
}
