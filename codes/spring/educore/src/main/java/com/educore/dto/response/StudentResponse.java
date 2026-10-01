package com.educore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String profilePhoto;
}