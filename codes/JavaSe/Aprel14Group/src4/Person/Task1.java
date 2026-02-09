package Person;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();

		int value = 10;

		while (numbers.size() < 40) {
			if (value % 2 == 0) {
				numbers.add(value);
			}
			value++;
		}

		System.out.println("Task 1 nəticə:");
		for (int num : numbers) {
			System.out.print(num + " ");
		}
	}
}
