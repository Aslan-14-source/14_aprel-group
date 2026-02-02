package Ders1;

public class Main {
	public static void main(String[] args) {
		Example example = new Example();

		int num1 = 10;
		int num2 = 0;

		try {
			int result = example.divideNumbers(num1, num2);
			System.out.println("Result: " + result);
		} catch (MyArithmeticException e) {
			System.out.println("Caught custom exception: " + e.getMyMessage());
		}
	}
}
//{Aslan}