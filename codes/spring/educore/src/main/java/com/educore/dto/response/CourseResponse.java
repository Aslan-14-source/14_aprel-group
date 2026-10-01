package com.educore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseResponse {

	private Long id;
	private String name;
	private String teacherName;
	private Integer credit;
}