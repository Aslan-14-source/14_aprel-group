import java.util.Scanner;

public class ShiftOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ədədi daxil edin (n): ");
		int n = scanner.nextInt();

		System.out.print("Shift miqdarını daxil edin (m): ");
		int m = scanner.nextInt();

		int leftShift = n << m;
		int rightShift = n >> m;

		System.out.println("\nShift əməliyyatlarının nəticələri:");
		System.out.println("n << m (Sol shift) = " + leftShift);
		System.out.println("n >> m (Sağ shift) = " + rightShift);

		scanner.close();
	}
}