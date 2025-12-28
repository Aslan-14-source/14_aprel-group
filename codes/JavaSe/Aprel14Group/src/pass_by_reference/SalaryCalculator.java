package pass_by_reference;

public class SalaryCalculator {
	  public void calculateSalary(Person p) {

	        if (p.experienceYear == 1) {
	            p.salary = 500;
	        } else if (p.experienceYear == 2) {
	            p.salary = 1000;
	        } else if (p.experienceYear == 3) {
	            p.salary = 1500;
	        } else if (p.experienceYear > 3) {
	            p.salary = 1500 + (p.experienceYear - 3) * 500;
	        } else {
	            p.salary = 0;
	        }
	    }
}
