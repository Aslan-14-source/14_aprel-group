package demo;

public class Task2 {

	    public static void main(String[] args) {

	        // 1-ci obyekt 
	        Computer c1 = new Computer();

	        // 2-ci obyekt
	        Computer c2 = new Computer("MacBook Pro");

	        // 3-cü obyekt
	        Computer c3 = new Computer("Lenovo ThinkPad", "Black");


	        System.out.println("\nComputer 1:");
	        System.out.println(c1.id + " " + c1.brand + " " + c1.model + " " + c1.color);

	        System.out.println("\nComputer 2:");
	        System.out.println(c2.id + " " + c2.brand + " " + c2.model + " " + c2.color);

	        System.out.println("\nComputer 3:");
	        System.out.println(c3.id + " " + c3.brand + " " + c3.model + " " + c3.color);
	    }
	}

	class Computer {

	    Integer id;
	    String brand;
	    String model;
	    String color;

	    // 1-ci:
	    Computer() {
	        System.out.println("Default constructor işə düşdü");
	        this.id = 0;
	        this.brand = "Unknown";
	        this.model = "Unknown";
	        this.color = "Unknown";
	    }

	    // 2-ci:
	    Computer(String model) {
	        System.out.println("Model qəbul edən constructor işə düşdü");
	        this.model = model;
	        this.id = 1;
	        this.brand = "Undefined";
	        this.color = "Undefined";
	    }

	    // 3-cü:
	    Computer(String model, String color) {
	        System.out.println("Model və color qəbul edən constructor işə düşdü");
	        this.model = model;
	        this.color = color;
	        this.id = 2;
	        this.brand = "Generic";
	    }
	}


