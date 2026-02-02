package Ders1;

public class Example {

	public int divideNumbers(int a, int b) throws MyArithmeticException {
		if (b == 0) {
			throw new MyArithmeticException("Cannot divide by zero!");
		}

		int result = 0;
		try {
			result = a / b;
		} catch (ArithmeticException e) {
			System.out.println("Caught standard ArithmeticException: " + e.getMessage());
		}

		return result;
	}
}
