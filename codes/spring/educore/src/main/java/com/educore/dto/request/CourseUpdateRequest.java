package com.educore.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseUpdateRequest {

	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String teacherName;

	@Min(1)
	@Max(10)
	private Integer credit;
}