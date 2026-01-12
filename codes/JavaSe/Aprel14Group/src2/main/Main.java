package main;

public class Main {
	public static void main(String[] args) {

		Circle2 circle = new Circle2(5.2);
		Rectangle rectangle = new Rectangle(4, 6);

		System.out.println("Circle Area: " + circle.getArea());
		System.out.println("Circle Perimeter: " + circle.getPerimeter());

		System.out.println("Rectangle Area: " + rectangle.getArea());
		System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
	}
}
