package demo;

public class Task3 {


	    public static void main(String[] args) {

	        // 1-ci Person
	        Person p1 = new Person();
	        p1.id = 1;
	        p1.name = "Aslan";
	        p1.surname = "Aliyev";
	        p1.age = 22;
	        p1.phone = "055-123-45-67";

	        // 2-ci Person
	        Person p2 = new Person();
	        p2.id = 2;
	        p2.name = "Murad";
	        p2.surname = "Huseynov";
	        p2.age = 25;
	        p2.phone = "070-987-65-43";


	        System.out.println("Person 1:");
	        System.out.println(p1.id);
	        System.out.println(p1.name);
	        System.out.println(p1.surname);
	        System.out.println(p1.age);
	        System.out.println(p1.phone);

	        System.out.println("\nPerson 2:");
	        System.out.println(p2.id);
	        System.out.println(p2.name);
	        System.out.println(p2.surname);
	        System.out.println(p2.age);
	        System.out.println(p2.phone);
	    }
	}

	class Person {
	    int id;
	    String name;
	    String surname;
	    int age;
	    String phone;
	}

