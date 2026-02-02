package Task;

public class Task {
	public static void main(String[] args) {

		// Ic-ice try-catch
		try {
			try {
				int[] a = { 1, 2 };
				System.out.println(a[4]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Multi-catch
		try {
			int x = 10 / 0;
			int[] b = { 1 };
			System.out.println(b[3]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

		// Try-catch-finally
		try {
			int y = 5 / 0;
			System.out.println(y);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally");
		}

		// Try-catch
		try {
			int z = 7 / 0;
			System.out.println(z);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
}