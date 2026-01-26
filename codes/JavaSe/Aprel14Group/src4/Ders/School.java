package Ders;

class School {

	static class Student {
		String name;
		int grade;

		void showInfo() {
			System.out.println("Ad: " + name);
			System.out.println("Sinif (Grade): " + grade);
		}
	}

	public static void main(String[] args) {

		Student student1 = new Student();

		student1.name = "Aslan";
		student1.grade = 10;

		student1.showInfo();
	}
}
