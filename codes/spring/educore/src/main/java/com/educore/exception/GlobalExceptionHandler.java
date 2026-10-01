package com.educore.exception;

import com.educore.dto.response.ValidationResponse;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.educore.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> studentNotFound(StudentNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> courseNotFound(CourseNotFoundException ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ApiResponse<Void>> alreadyExists(ResourceAlreadyExistsException ex) {

		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<ApiResponse<Void>> fileError(FileStorageException ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<>(false, ex.getMessage(), null));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<ValidationResponse>> handleValidationException(
			MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.merge(error.getField(), error.getDefaultMessage(),
					(existing, incoming) -> existing + "; " + incoming);
		});

		ValidationResponse validationResponse = new ValidationResponse(errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse<>(false, "Validation xətası", validationResponse));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> generalError(Exception ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<>(false, "Gözlənilməz xəta baş verdi", null));
	}
}