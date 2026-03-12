package studentManagementSystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import studentManagementSystem.entity.Student;

public class StudentRepository {

	public void addStudent(Student student) {

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root",
					"aslan2011");

			String sql = "INSERT INTO students(name,surname,age) VALUES(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getSurname());
			ps.setInt(3, student.getAge());

			ps.executeUpdate();

			System.out.println("Student added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}