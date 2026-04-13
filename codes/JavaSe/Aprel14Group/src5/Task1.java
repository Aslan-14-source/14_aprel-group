public class Task1 {

	public static boolean isOnlyDigits(String str) {
		return str.matches("\\d+");
	}

	public static void main(String[] args) {
		System.out.println(isOnlyDigits("12345"));
	}
}