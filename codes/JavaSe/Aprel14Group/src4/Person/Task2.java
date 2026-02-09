package Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("Apple");
		words.add("Banana");
		words.add("Orange");
		words.add("Mango");
		words.add("Grape");

		System.out.println("Original List:");
		for (String word : words) {
			System.out.print(word + " ");
		}

		Collections.reverse(words);

		System.out.println("\n\nTərsinə çevrilmiş List:");
		for (String word : words) {
			System.out.print(word + " ");
		}
	}
}
