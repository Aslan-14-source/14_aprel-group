package main;

public class Employee extends Person {

	protected double salary;
	protected String department;
	protected String username;
	protected String password;

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Maaş: " + salary);
		System.out.println("Şöbə: " + department);
		System.out.println("İstifadəçi adı: " + username);
		System.out.println("Şifrə: " + password);
	}
}
