package main;

public class Calculator {
    void calculateCircleLength(Circle c) {
        double result = 2 * Math.PI * c.radius;
        c.length = result;
    }
}