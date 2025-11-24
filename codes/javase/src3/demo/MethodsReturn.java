package demo;

	class Calculator {
	    double average(int a, int b) {
	        return (a + b) / 2.0;
	    }
	}

	public class MethodsReturn {
	    public static void main(String[] args) {

	        Calculator calc = new Calculator();

	        double avg1 = calc.average(10, 20);
	        double avg2 = calc.average(5, 15);

	        System.out.println("Orta 1: " + avg1);
	        System.out.println("Orta 2: " + avg2);
	    }
	}

