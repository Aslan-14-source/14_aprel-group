package Homework;

public class Main {
	public static void main(String[] args) {

		String text = "Java123 is fun 456 and COOL789!";

		boolean hasDigit = text.matches(".*\\d.*");
		System.out.println(hasDigit);

		String noDigits = text.replaceAll("\\d", "");
		System.out.println(noDigits);

		String noSpaces = text.replaceAll("\\s", "");
		System.out.println(noSpaces);

		String replaced = text.replaceAll("\\d", "#");
		System.out.println(replaced);
	}
}
