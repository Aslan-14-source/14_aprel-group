package demo;

public class Task4 {

	    public static void main(String[] args) {

	        Employee emp1 = new Employee();  
	        Employee emp2 = new Employee("Aslan");  
	        Employee emp3 = new Employee("Leyla", "Qasimova");  
	        Employee emp4 = new Employee("Murad", "0501234567", 1200);

	        emp1.printInfo();
	        emp2.printInfo();
	        emp3.printInfo();
	        emp4.printInfo();
	    }
	}


	class Employee {

	    int id;
	    String name;
	    String surname;
	    String phone;
	    String address;
	    int salary;

	    // 1-ci:
	    Employee() {
	        System.out.println("Default constructor işə düşdü");
	    }

	    // 2-ci:
	    Employee(String name) {
	        System.out.println("2-ci constructor işə düşdü: name = " + name);
	        this.name = name;
	    }

	    // 3-cü:
	    Employee(String name, String surname) {
	        System.out.println("3-cü constructor işə düşdü: name = " + name + ", surname = " + surname);
	        this.name = name;
	        this.surname = surname;
	    }

	    // 4-cü:
	    Employee(String name, String phone, int salary) {
	        System.out.println("4-cü constructor işə düşdü: name = " + name + ", phone = " + phone + ", salary = " + salary);
	        this.name = name;
	        this.phone = phone;
	        this.salary = salary;
	    }

	    void printInfo() {
	        System.out.println("-----------------------");
	        System.out.println("id: " + id);
	        System.out.println("name: " + name);
	        System.out.println("surname: " + surname);
	        System.out.println("phone: " + phone);
	        System.out.println("address: " + address);
	        System.out.println("salary: " + salary);
	        System.out.println("-----------------------");
	    }
	}
