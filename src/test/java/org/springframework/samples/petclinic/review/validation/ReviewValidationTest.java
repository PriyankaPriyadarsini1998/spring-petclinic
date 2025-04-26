package org.springframework.samples.petclinic.review.validation;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.review.model.Review;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Pet clinic Review Validations
 *
 * @author PriyankaPriyadarsini
 */
public class ReviewValidationTest {

	private Validator validator;

	@BeforeEach
	void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// Throws Validation when author name is blank
	@Test
	void whenAuthorIsBlank_thenValidationFails() {
		Review review = new Review();
		review.setAuthor("   "); // blank
		review.setContent("Good service");

		Set<ConstraintViolation<Review>> violations = validator.validate(review);
		assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("author"));
	}

	// Throws Validation when content is blank
	@Test
	void whenContentIsBlank_thenValidationFails() {
		Review review = new Review();
		review.setAuthor("John");
		review.setContent("  ");

		Set<ConstraintViolation<Review>> violations = validator.validate(review);
		assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("content"));
	}

	// Throws Validation when author name is beyond 100 chars
	@Test
	void whenAuthorTooLong_thenValidationFails() {
		Review review = new Review();
		review.setAuthor("A".repeat(101)); // 101 chars
		review.setContent("Everything else is fine.");

		Set<ConstraintViolation<Review>> violations = validator.validate(review);
		assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("author"));
	}

	// Throws Validation when content is beyond 500 chars
	@Test
	void whenContentTooLong_thenValidationFails() {
		Review review = new Review();
		review.setAuthor("John Doe");
		review.setContent("B".repeat(501));

		Set<ConstraintViolation<Review>> violations = validator.validate(review);
		assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("content"));
	}

}
