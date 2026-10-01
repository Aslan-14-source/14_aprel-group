package com.educore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.educore.dto.response.CourseResponse;
import com.educore.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	boolean existsByName(String name);

	Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);

	Page<CourseResponse> searchByName(String name, Pageable pageable);
}