package Person;

import java.util.HashSet;
import java.util.Set;

public class Task3 {
	public static void main(String[] args) {

		Set<String> colors = new HashSet<>();

		colors.add("Red");
		colors.add("Gray");
		colors.add("Black");
		colors.add("Purple");
		colors.add("White");
		colors.add("Green");
		colors.add("Blue");

		for (String color : colors) {
			System.out.println(colors);
		}
	}
}
