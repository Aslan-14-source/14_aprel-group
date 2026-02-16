package Task;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
	public static void main(String[] args) {

		Map<String, Integer> students = new HashMap<>();

		students.put("Ali", 10);
		students.put("Aysel", 13);
		students.put("Murad", 15);
		students.put("Leyla", 12);
		students.put("Kamal", 14);

		System.out.println("Qrupdakı bütün uşaqlar:");
		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			System.out.println("Ad: " + entry.getKey() + ", Yaş: " + entry.getValue());
		}

		System.out.println("\nYaşı 12-dən böyük olanlar:");
		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			if (entry.getValue() > 12) {
				System.out.println("Ad: " + entry.getKey() + ", Yaş: " + entry.getValue());
			}
		}
	}
}
 