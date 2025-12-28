package Src;

public class Task1 {
	public class ReverseString {
		public static void main(String[] args) {
			String word = "salam";
			String reversed = "";

			for (int i = word.length() - 1; i >= 0; i--) {
				reversed += word.charAt(i);
			}

			System.out.println(reversed);
		}
	}

}
