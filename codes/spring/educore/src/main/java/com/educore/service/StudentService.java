package com.educore.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.educore.dto.request.StudentCreateRequest;
import com.educore.dto.request.StudentUpdateRequest;
import com.educore.dto.response.StudentResponse;
import com.educore.entity.Course;
import com.educore.entity.Student;
import com.educore.exception.CourseNotFoundException;
import com.educore.exception.FileStorageException;
import com.educore.exception.ResourceAlreadyExistsException;
import com.educore.exception.StudentNotFoundException;
import com.educore.mapper.StudentMapper;
import com.educore.repository.CourseRepository;
import com.educore.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final StudentMapper studentMapper;
	
	@Autowired
	private ModelMapper mapper;

	private final Path uploadPath = Paths.get("uploads/profile-photos");

	// CREATE
	public StudentResponse create(StudentCreateRequest request) {

		if (studentRepository.existsByEmail(request.getEmail())) {

			throw new ResourceAlreadyExistsException("Bu email artıq mövcuddur");
		}
		
		Student student = new Student();
		

//		Student student = studentMapper.toEntity(request);
		mapper.map(request, student);

		Student saved = studentRepository.save(student);

		return studentMapper.toResponse(saved);
	}

	// FIND ALL
	public Page<StudentResponse> findAll(Pageable pageable) {

		return studentRepository.findAll(pageable).map(studentMapper::toResponse);
	}

	// FIND BY ID
	public StudentResponse findById(Long id) {

		Student student = getStudent(id);

		return studentMapper.toResponse(student);
	}

	// UPDATE
	public StudentResponse update(StudentUpdateRequest request) {

		Student student = getStudent(request.getId());

		if (!student.getEmail().equals(request.getEmail()) && studentRepository.existsByEmail(request.getEmail())) {

			throw new ResourceAlreadyExistsException("Bu email artıq istifadə olunur");
		}

		student.setFirstName(request.getFirstName());

		student.setLastName(request.getLastName());

		student.setAge(request.getAge());

		student.setEmail(request.getEmail());

		Student updated = studentRepository.save(student);

		return studentMapper.toResponse(updated);
	}

	// DELETE
	public void delete(Long id) {

		Student student = getStudent(id);

		studentRepository.delete(student);
	}

	// SEARCH
	public Page<StudentResponse> search(String name, Pageable pageable) {

		return studentRepository.searchByName(name, pageable).map(studentMapper::toResponse);
	}

	// ASSIGN COURSE
	public void assignCourse(Long studentId, Long courseId) {

		Student student = getStudent(studentId);

		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course tapılmadı: " + courseId));

		if (!student.getCourses().contains(course)) {

			student.getCourses().add(course);

			studentRepository.save(student);
		}
	}

	// REMOVE COURSE
	public void removeCourse(Long studentId, Long courseId) {

		Student student = getStudent(studentId);

		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new CourseNotFoundException("Course tapılmadı: " + courseId));

		student.getCourses().remove(course);

		studentRepository.save(student);
	}

	// GET COURSES
	public List<Course> getCourses(Long studentId) {

		Student student = getStudent(studentId);

		return student.getCourses();
	}

	// UPLOAD PHOTO
	public void uploadPhoto(Long studentId, MultipartFile file) {

		Student student = getStudent(studentId);

		try {

			Files.createDirectories(uploadPath);

			String fileName = studentId + "_" + file.getOriginalFilename();

			Path filePath = uploadPath.resolve(fileName);

			Files.write(filePath, file.getBytes());

			student.setProfilePhoto(fileName);

			studentRepository.save(student);

		} catch (IOException e) {

			throw new FileStorageException("Şəkil yadda saxlanıla bilmədi", e);
		}
	}

	// DOWNLOAD PHOTO
	public byte[] downloadPhoto(Long studentId) {

		Student student = getStudent(studentId);

		if (student.getProfilePhoto() == null) {

			throw new FileStorageException("Student-in şəkli yoxdur");
		}

		try {

			Path filePath = uploadPath.resolve(student.getProfilePhoto());

			return Files.readAllBytes(filePath);

		} catch (IOException e) {

			throw new FileStorageException("Şəkil oxuna bilmədi", e);
		}
	}

	// DELETE PHOTO
	public void deletePhoto(Long studentId) {

		Student student = getStudent(studentId);

		if (student.getProfilePhoto() == null) {
			return;
		}

		try {

			Path filePath = uploadPath.resolve(student.getProfilePhoto());

			Files.deleteIfExists(filePath);

			student.setProfilePhoto(null);

			studentRepository.save(student);

		} catch (IOException e) {

			throw new FileStorageException("Şəkil silinə bilmədi", e);
		}
	}

	private Student getStudent(Long id) {

		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student tapılmadı: " + id));
	}
}