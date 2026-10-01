package com.educore.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateRequest {

	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Min(15)
	@Max(70)
	private Integer age;

	@NotBlank
	@Email
	private String email;
}