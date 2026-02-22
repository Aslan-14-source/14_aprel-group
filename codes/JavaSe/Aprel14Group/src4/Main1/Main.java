package Main1;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		ArrayList<Person> list = new ArrayList<>();

		list.add(new Person("Aslan", 22));
		list.add(new Person("Ali", 18));
		list.add(new Person("Nigar", 25));
		list.add(new Person("Hummet", 20));

		Comparator<Person> ageComparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}
		};

		Collections.sort(list, ageComparator);

		System.out.println("sıralanmış siyahı:");
		for (Person p : list) {
			System.out.println(p);
		}
	}
}