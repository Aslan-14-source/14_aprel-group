package com.educore.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCreateRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String teacherName;

	@NotNull
	@Min(1)
	@Max(10)
	private Integer credit;
}