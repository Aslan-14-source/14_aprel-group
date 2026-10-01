package com.educore.mapper;

import org.springframework.stereotype.Component;

import com.educore.dto.request.CourseCreateRequest;
import com.educore.dto.request.CourseUpdateRequest;
import com.educore.dto.response.CourseResponse;
import com.educore.entity.Course;

@Component
public class CourseMapper {

	public Course toEntity(CourseCreateRequest request) {

		Course course = new Course();

		course.setName(request.getName());
		course.setTeacherName(request.getTeacherName());
		course.setCredit(request.getCredit());

		return course;
	}

	public CourseResponse toResponse(Course course) {

		return new CourseResponse(course.getId(), course.getName(), course.getTeacherName(), course.getCredit());
	}

	public void updateEntity(Course course, CourseUpdateRequest request) {

		course.setName(request.getName());
		course.setTeacherName(request.getTeacherName());
		course.setCredit(request.getCredit());
	}
}
