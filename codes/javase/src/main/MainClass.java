package main;

public class MainClass {
    public static void main(String[] args) {

        Circle circle = new Circle();
        circle.radius = 5;

        Calculator calc = new Calculator();
        calc.calculateCircleLength(circle);

        System.out.println("Dairənin uzunluğu: " + circle.length);
    }
}

