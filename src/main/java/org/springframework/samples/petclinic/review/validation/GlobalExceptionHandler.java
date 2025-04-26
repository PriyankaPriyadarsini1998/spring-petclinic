package org.springframework.samples.petclinic.review.validation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler class for Pet clinic Review
 *
 * @author PriyankaPriyadarsini
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		// Get first validation error message
		String message = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.findFirst()
			.map(error -> error.getDefaultMessage())
			.orElse("Validation error");

		// Build error response
		ErrorResponse response = ErrorResponse.of(message, request.getRequestURI(),
				HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());

		return ResponseEntity.unprocessableEntity().body(response);
	}

}
