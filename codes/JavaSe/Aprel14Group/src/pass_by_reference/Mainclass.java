package pass_by_reference;

public class Mainclass {
	 public static void main(String[] args) {

	        Person person = new Person("Aslan", "Qasimov", 4, "055-555-55-55");

	        SalaryCalculator calculator = new SalaryCalculator();

	        calculator.calculateSalary(person);

	        person.printInfo();
	    }
}
