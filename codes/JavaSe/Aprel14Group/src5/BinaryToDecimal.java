import java.util.Scanner;

public class BinaryToDecimal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Binary ədədi daxil edin: ");
		String binary = scanner.nextLine();

		try {
			int decimal = Integer.parseInt(binary, 2);
			System.out.println("Decimal qarşılığı: " + decimal);
		} catch (NumberFormatException e) {
			System.out.println("Xəta: Zəhmət olmasa yalnız 0 və 1 rəqəmlərindən istifadə edin.");
		}

		scanner.close();
	}
}