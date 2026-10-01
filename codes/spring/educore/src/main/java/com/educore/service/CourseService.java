package com.educore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.educore.dto.request.CourseCreateRequest;
import com.educore.dto.request.CourseUpdateRequest;
import com.educore.dto.response.CourseResponse;
import com.educore.entity.Course;
import com.educore.exception.CourseNotFoundException;
import com.educore.exception.ResourceAlreadyExistsException;
import com.educore.mapper.CourseMapper;
import com.educore.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseRepository courseRepository;
	private final CourseMapper courseMapper;

	// CREATE
	public CourseResponse create(CourseCreateRequest request) {

		if (courseRepository.existsByName(request.getName())) {

			throw new ResourceAlreadyExistsException("Bu kurs artıq mövcuddur");
		}

		Course course = courseMapper.toEntity(request);

		Course saved = courseRepository.save(course);

		return courseMapper.toResponse(saved);
	}

	// FIND ALL
	public Page<CourseResponse> findAll(Pageable pageable) {

		return courseRepository.findAll(pageable).map(courseMapper::toResponse);
	}

	// FIND BY ID
	public CourseResponse findById(Long id) {

		Course course = getCourse(id);

		return courseMapper.toResponse(course);
	}

	// UPDATE
	public CourseResponse update(CourseUpdateRequest request) {

		Course course = getCourse(request.getId());

		course.setName(request.getName());

		course.setTeacherName(request.getTeacherName());

		course.setCredit(request.getCredit());

		Course updated = courseRepository.save(course);

		return courseMapper.toResponse(updated);
	}

	// DELETE
	public void delete(Long id) {

		Course course = getCourse(id);

		courseRepository.delete(course);
	}

	// SEARCH
	public Page<CourseResponse> search(String name, Pageable pageable) {
	
			return courseRepository.searchByName(name, pageable).map(courseMapper::toResponse);
	}

	// GET STUDENTS
	public List<?> getStudents(Long id) {

		Course course = getCourse(id);

		return course.getStudents();
	}

	private Course getCourse(Long id) {

		return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course tapılmadı: " + id));
	}
}