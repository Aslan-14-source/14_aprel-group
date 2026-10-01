package com.educore.controller;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.educore.dto.request.StudentCreateRequest;
import com.educore.dto.request.StudentUpdateRequest;
import com.educore.dto.response.ApiResponse;
import com.educore.dto.response.StudentResponse;
import com.educore.entity.Course;
import com.educore.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name = "Student API", description = "Student idarəetməsi üçün REST API")
public class StudentController {

	private final StudentService studentService;

	// CREATE STUDENT
	@PostMapping
	@Operation(summary = "Yeni student yarat", description = "Yeni student yaradır")
	public ResponseEntity<ApiResponse<StudentResponse>> create(@Valid @RequestBody StudentCreateRequest request) {

		StudentResponse response = studentService.create(request);

		return ResponseEntity.ok(new ApiResponse<>(true, "Student yaradıldı", response));
	}

	// GET ALL STUDENTS
	@GetMapping
	@Operation(summary = "Bütün student-ləri gətir", description = "Bütün student-ləri pagination ilə gətirir")
	public ResponseEntity<Page<StudentResponse>> findAll(Pageable pageable) {

		return ResponseEntity.ok(studentService.findAll(pageable));
	}

	// GET STUDENT BY ID
	@GetMapping("/{id}")
	@Operation(summary = "ID ilə student tap", description = "ID-yə uyğun student məlumatlarını gətirir")
	public ResponseEntity<ApiResponse<StudentResponse>> findById(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long id) {

		return ResponseEntity.ok(new ApiResponse<>(true, "Student tapıldı", studentService.findById(id)));
	}

	// UPDATE STUDENT
	@PutMapping
	@Operation(summary = "Student yenilə", description = "Mövcud student məlumatlarını yeniləyir")
	public ResponseEntity<ApiResponse<StudentResponse>> update(@Valid @RequestBody StudentUpdateRequest request) {

		return ResponseEntity.ok(new ApiResponse<>(true, "Student yeniləndi", studentService.update(request)));
	}

	// DELETE STUDENT
	@DeleteMapping("/{id}")
	@Operation(summary = "Student sil", description = "ID-yə uyğun student-i silir")
	public ResponseEntity<ApiResponse<Void>> delete(

			@Parameter(description = "Silinəcək student ID", example = "1") @PathVariable Long id) {

		studentService.delete(id);

		return ResponseEntity.ok(new ApiResponse<>(true, "Student silindi", null));
	}

	// SEARCH STUDENTS
	@GetMapping("/search")
	@Operation(summary = "Student axtar", description = "Student adına görə axtarış edir")
	public ResponseEntity<Page<StudentResponse>> search(

			@Parameter(description = "Axtarılacaq student adı", example = "Ali") @RequestParam String name,

			Pageable pageable) {

		return ResponseEntity.ok(studentService.search(name, pageable));
	}

	// UPLOAD PHOTO
	@PostMapping(value = "/{id}/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "Student üçün şəkil yüklə", description = "Student-in şəklini sistemə yükləyir")
	public ResponseEntity<ApiResponse<Void>> uploadPhoto(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long id,

			@Parameter(description = "Yüklənəcək şəkil") @RequestParam("file") MultipartFile file) {

		studentService.uploadPhoto(id, file);

		return ResponseEntity.ok(new ApiResponse<>(true, "Şəkil yükləndi", null));
	}

	// DOWNLOAD PHOTO
	@GetMapping(value = "/{id}/photo", produces = MediaType.IMAGE_JPEG_VALUE)
	@Operation(summary = "Student şəklini gətir", description = "Student-in şəklini qaytarır")
	public ResponseEntity<ByteArrayResource> downloadPhoto(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long id) {

		byte[] image = studentService.downloadPhoto(id);

		ByteArrayResource resource = new ByteArrayResource(image);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline").contentType(MediaType.IMAGE_JPEG)
				.body(resource);
	}

	// DELETE PHOTO
	@DeleteMapping("/{id}/photo")
	@Operation(summary = "Student şəklini sil", description = "Student-in şəklini silir")
	public ResponseEntity<ApiResponse<Void>> deletePhoto(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long id) {

		studentService.deletePhoto(id);

		return ResponseEntity.ok(new ApiResponse<>(true, "Şəkil silindi", null));
	}

	// ASSIGN COURSE
	@PostMapping("/{studentId}/courses/{courseId}")
	@Operation(summary = "Student-ə course təyin et", description = "Student-i course-a əlavə edir")
	public ResponseEntity<ApiResponse<Void>> assignCourse(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long studentId,

			@Parameter(description = "Course ID", example = "1") @PathVariable Long courseId) {

		studentService.assignCourse(studentId, courseId);

		return ResponseEntity.ok(new ApiResponse<>(true, "Student kursa qeyd edildi", null));
	}

	// REMOVE COURSE
	@DeleteMapping("/{studentId}/courses/{courseId}")
	@Operation(summary = "Student-i course-dan çıxar", description = "Student-i course-dan silir")
	public ResponseEntity<ApiResponse<Void>> removeCourse(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long studentId,

			@Parameter(description = "Course ID", example = "1") @PathVariable Long courseId) {

		studentService.removeCourse(studentId, courseId);

		return ResponseEntity.ok(new ApiResponse<>(true, "Student kursdan çıxarıldı", null));
	}

	// GET STUDENT COURSES
	@GetMapping("/{studentId}/courses")
	@Operation(summary = "Student-in course-larını gətir", description = "Student-in qeydiyyatda olduğu course-ları gətirir")
	public ResponseEntity<List<Course>> getCourses(

			@Parameter(description = "Student ID", example = "1") @PathVariable Long studentId) {

		return ResponseEntity.ok(studentService.getCourses(studentId));
	}
}