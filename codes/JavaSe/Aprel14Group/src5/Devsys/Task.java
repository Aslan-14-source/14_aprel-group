package Devsys;

import java.util.*;

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return name + " - " + score;
	}
}

public class Task {
	  public static void main(String[] args) {

	        List<Student> students = Arrays.asList(
	                new Student("Ali", 45),
	                new Student("Veli", 78),
	                new Student("Aysel", 92),
	                new Student("Murad", 55),
	                new Student("Leyla", 33)
	        );

	        List<String> boyukBal = students.stream()
	                .filter(x -> x.score > 50)
	                .map(x -> x.name + " - " + x.score)
	                .toList();

	        List<String> boyukHerfAdlar = students.stream()
	                .filter(x -> true)
	                .map(x -> x.name.toUpperCase())
	                .toList();

	        int maxScore = students.stream()
	                .map(x -> x.score)
	                .reduce((a, b) -> a > b ? a : b)
	                .get();

	        System.out.println("50-dən böyük bal alanlar: " + boyukBal);
	        System.out.println("Adlar böyük hərflə: " + boyukHerfAdlar);
	        System.out.println("Ən yüksək bal: " + maxScore);
	    }
	}