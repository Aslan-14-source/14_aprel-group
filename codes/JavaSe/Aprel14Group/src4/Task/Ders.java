package Task;

public class Ders {

	public static void main(String[] args) {

		int a = 10;
		int b = 0;
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println("Xəta tutuldu");
		}

		int[] arr = { 1, 2, 3 };
		try {
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Xəta tutuldu");
		} finally {
			System.out.println("finally bloku işlədi");
		}

		try {
			String s = null;
			try {
				System.out.println(s.length());
			} catch (NullPointerException e) {
				System.out.println("Daxili catch");
			}
		} catch (Exception e) {
			System.out.println("Xarici catch");
		}

		try {
			int x = Integer.parseInt("abc");
			int y = 10 / 0;
		} catch (NumberFormatException | ArithmeticException e) {
			System.out.println("Multi-catch tutuldu");
		}

	}
}
