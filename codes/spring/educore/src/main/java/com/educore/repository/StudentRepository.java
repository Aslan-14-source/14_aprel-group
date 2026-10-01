package com.educore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educore.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// Query Method 1
	Optional<Student> findByEmail(String email);

	// Query Method 2
	List<Student> findByFirstName(String firstName);

	// Query Method 3
	List<Student> findByLastName(String lastName);

	// Query Method 4
	List<Student> findByAgeGreaterThan(Integer age);

	// Query Method 5
	List<Student> findByAgeLessThan(Integer age);

	// Query Method 6
	boolean existsByEmail(String email);

	// JPQL 1
	@Query("""
			SELECT s FROM Student s
			WHERE LOWER(s.firstName)
			LIKE LOWER(CONCAT('%', :name, '%'))
			""")
	Page<Student> searchByName(@Param("name") String name, Pageable pageable);

	// JPQL 2
	@Query("""
			SELECT s FROM Student s
			WHERE s.age BETWEEN :minAge AND :maxAge
			""")
	List<Student> findByAgeBetween(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

	// JPQL 3
	@Query("""
			SELECT s FROM Student s
			WHERE s.email = :email
			""")
	Optional<Student> findStudentByEmail(@Param("email") String email);

	// JPQL 4
	@Query("""
			SELECT s FROM Student s
			WHERE s.firstName = :name
			""")
	List<Student> findStudentByFirstName(@Param("name") String name);

	// JPQL 5
	@Query("""
			SELECT s FROM Student s
			WHERE s.lastName = :name
			""")
	List<Student> findStudentByLastName(@Param("name") String name);

	// Native Query 1
	@Query(value = "SELECT * FROM students WHERE age >= :age", nativeQuery = true)
	List<Student> findOlderStudents(@Param("age") Integer age);

	// Native Query 2
	@Query(value = "SELECT * FROM students WHERE first_name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
	List<Student> searchNative(@Param("name") String name);

	// Native Query 3
	@Query(value = "SELECT COUNT(*) FROM students", nativeQuery = true)
	Long countStudents();
}