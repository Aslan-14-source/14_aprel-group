import java.util.Scanner;

public class BitwiseOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci tam ədədi daxil edin (a): ");
		int a = scanner.nextInt();

		System.out.print("İkinci tam ədədi daxil edin (b): ");
		int b = scanner.nextInt();

		int andResult = a & b;
		int orResult = a | b;
		int xorResult = a ^ b;

		System.out.println("\nNəticələr:");
		System.out.println("a & b (AND) = " + andResult);
		System.out.println("a | b (OR)  = " + orResult);
		System.out.println("a ^ b (XOR) = " + xorResult);

		scanner.close();
	}
}