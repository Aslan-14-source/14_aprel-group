import java.util.Scanner;

public class NumberSystemConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Decimal ədədi daxil edin: ");
		int decimal = scanner.nextInt();

		String binary = Integer.toBinaryString(decimal);
		String octal = Integer.toOctalString(decimal);
		String hexadecimal = Integer.toHexString(decimal).toUpperCase();

		System.out.println("Binary (ikilik): " + binary);
		System.out.println("Octal (səkkizlik): " + octal);
		System.out.println("Hexadecimal (16-lıq): " + hexadecimal);

		scanner.close();
	}
}