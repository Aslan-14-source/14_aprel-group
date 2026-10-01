package com.educore.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Kurs adı boş ola bilməz")
	private String name;

	@NotBlank(message = "Teacher adı boş ola bilməz")
	private String teacherName;

	@Min(value = 1, message = "Credit minimum 1 olmalıdır")
	@Max(value = 10, message = "Credit maksimum 10 olmalıdır")
	private Integer credit;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();
}
