package Task;

import java.util.HashSet;
import java.util.Set;

public class Task3 {
	public static void main(String[] args) {

		String text = "hello world";

		Set<Character> letters = new HashSet<>();

		for (char ch : text.toCharArray()) {
			if (Character.isLetter(ch)) {
				letters.add(ch);
			}
		}

		System.out.println("Fərqli hərflər: " + letters);
		System.out.println("Fərqli hərflərin sayı: " + letters.size());
	}
}
