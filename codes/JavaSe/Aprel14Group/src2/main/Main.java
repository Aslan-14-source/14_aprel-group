package main;

public class Main {
	public static void main(String[] args) {

		Employee emp = new Employee();

		emp.id = 1;
		emp.name = "Aslan";
		emp.surname = "Qasimov";
		emp.age = 15;
		emp.phone = "050-123-45-67";
		emp.address = "Bakı";

		emp.salary = 1500;
		emp.department = "IT";
		emp.username = "aslan123";
		emp.password = "12345";

		emp.printInfo();
	}
}
