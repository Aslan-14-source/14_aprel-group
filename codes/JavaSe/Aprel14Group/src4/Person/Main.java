package Person;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		ArrayList<String> students = new ArrayList<>();
		students.add("Aslan");
		students.add("Mustafa");
		students.add("Omer");
		students.add("Yusif");
		students.add("Vuqar");
		students.add("Sema");
		students.add("Aliimran");
		students.add("Rahman");
		students.add("Turqay");

		ArrayList<Integer> grades = new ArrayList<>();

		grades.add(90);
		grades.add(95);
		grades.add(94);
		grades.add(93);
		grades.add(91);
		grades.add(98);
		grades.add(99);
		grades.add(81);
		grades.add(89);

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i) + " - Grade: " + grades.get(i));
		}
	}
}