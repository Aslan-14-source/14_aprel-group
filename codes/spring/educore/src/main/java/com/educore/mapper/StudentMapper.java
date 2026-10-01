package com.educore.mapper;

import org.springframework.stereotype.Component;

import com.educore.dto.request.StudentCreateRequest;
import com.educore.dto.response.StudentResponse;
import com.educore.entity.Student;

@Component
public class StudentMapper {

	public Student toEntity(StudentCreateRequest request) {

		Student student = new Student();

		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setAge(request.getAge());
		student.setEmail(request.getEmail());

		return student;
	}

	public StudentResponse toResponse(Student student) {

		return new StudentResponse(student.getId(), student.getFirstName(), student.getLastName(), student.getAge(),
				student.getEmail(), student.getProfilePhoto());
	}
}