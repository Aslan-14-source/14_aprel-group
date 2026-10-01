package com.educore.controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educore.dto.request.CourseCreateRequest;
import com.educore.dto.request.CourseUpdateRequest;
import com.educore.dto.response.ApiResponse;
import com.educore.dto.response.CourseResponse;
import com.educore.service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@Tag(name = "Course API", description = "Course idarəetməsi üçün REST API")
public class CourseController {

	private final CourseService courseService;

	// CREATE COURSE
	@PostMapping
	@Operation(summary = "Yeni course yarat", description = "Yeni course yaradır")
	public ResponseEntity<ApiResponse<CourseResponse>> create(@Valid @RequestBody CourseCreateRequest request) {

		return ResponseEntity.ok(new ApiResponse<>(true, "Course yaradıldı", courseService.create(request)));
	}

	// GET ALL COURSES
	@GetMapping
	@Operation(summary = "Bütün course-ları gətir", description = "Bütün course-ları pagination ilə gətirir")
	public ResponseEntity<Page<CourseResponse>> findAll(Pageable pageable) {

		return ResponseEntity.ok(courseService.findAll(pageable));
	}

	// GET COURSE BY ID
	@GetMapping("/{id}")
	@Operation(summary = "ID ilə course tap", description = "ID-yə uyğun course məlumatlarını gətirir")
	public ResponseEntity<ApiResponse<CourseResponse>> findById(

			@Parameter(description = "Course ID", example = "1") @PathVariable Long id) {

		return ResponseEntity.ok(new ApiResponse<>(true, "Course tapıldı", courseService.findById(id)));
	}

	// UPDATE COURSE
	@PutMapping
	@Operation(summary = "Course yenilə", description = "Mövcud course məlumatlarını yeniləyir")
	public ResponseEntity<ApiResponse<CourseResponse>> update(@Valid @RequestBody CourseUpdateRequest request) {

		return ResponseEntity.ok(new ApiResponse<>(true, "Course yeniləndi", courseService.update(request)));
	}

	// DELETE COURSE
	@DeleteMapping("/{id}")
	@Operation(summary = "Course sil", description = "ID-yə uyğun course-u silir")
	public ResponseEntity<ApiResponse<Void>> delete(

			@Parameter(description = "Silinəcək course ID", example = "1") @PathVariable Long id) {

		courseService.delete(id);

		return ResponseEntity.ok(new ApiResponse<>(true, "Course silindi", null));
	}

	// SEARCH COURSES
	@GetMapping("/search")
	@Operation(summary = "Course axtar", description = "Course adını istifadə edərək axtarış edir")
	public ResponseEntity<Page<CourseResponse>> search(

			@Parameter(description = "Axtarılacaq course adı", example = "Java") @RequestParam String name,

			Pageable pageable) {

		return ResponseEntity.ok(courseService.search(name, pageable));
	}

	// GET STUDENTS OF COURSE
	@GetMapping("/{id}/students")
	@Operation(summary = "Course-un tələbələrini gətir", description = "Verilmiş course-a qeydiyyatdan keçmiş tələbələri gətirir")
	public ResponseEntity<List<?>> getStudents(

			@Parameter(description = "Course ID", example = "1") @PathVariable Long id) {

		return ResponseEntity.ok(courseService.getStudents(id));
	}
}