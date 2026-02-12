package Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(50);
		list.add(40);
		list.add(30);
		list.add(10);
		Set<Integer> unique = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();

		for (Integer num : list) {
			if (!unique.add(num)) {
				duplicates.add(num);
			}
		}
		System.out.println("Tekrarlanan elementler");
		for (Integer dup : duplicates) {
			System.out.println(dup);
		}
	}
}
