package org.springframework.samples.petclinic.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.samples.petclinic.review.model.Review;
import org.springframework.samples.petclinic.review.repository.ReviewRepository;
import org.springframework.samples.petclinic.review.service.ReviewService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/**
 * Test class for Pet clinic Review service
 *
 * @author PriyankaPriyadarsini
 */
class ReviewServiceTest {

	@Mock
	private ReviewRepository reviewRepository;

	@InjectMocks
	private ReviewService reviewService;

	private AutoCloseable mocks;

	@BeforeEach
	void setUp() {
		mocks = MockitoAnnotations.openMocks(this);
	}

	// when review is saved successfully
	@Test
	void save_shouldSaveReview() {
		Review review = new Review();
		review.setAuthor("Alice");
		review.setContent("Great service!");
		when(reviewRepository.save(review)).thenReturn(review);
		Review result = reviewService.save(review);
		assertThat(result).isNotNull();
		assertThat(result.getAuthor()).isEqualTo("Alice");
		verify(reviewRepository, times(1)).save(review);
	}

	// when all review is fetched successfully
	@Test
	void getAll_shouldReturnAllReviews() {
		Review r1 = new Review();
		Review r2 = new Review();
		when(reviewRepository.findAll()).thenReturn(Arrays.asList(r1, r2));
		List<Review> reviews = reviewService.getAll();
		assertThat(reviews).hasSize(2);
		verify(reviewRepository, times(1)).findAll();
	}

	// when save() throws exception
	@Test
	void save_shouldThrowException_whenRepositoryFails() {
		Review review = new Review();
		review.setAuthor("ErrorUser");
		review.setContent("Will fail");

		when(reviewRepository.save(review)).thenThrow(new RuntimeException("Database error"));

		assertThatThrownBy(() -> reviewService.save(review)).isInstanceOf(RuntimeException.class)
			.hasMessageContaining("Database error");

		verify(reviewRepository, times(1)).save(review);
	}

	// when getAll() returns empty
	@Test
	void getAll_shouldReturnEmptyList_whenNoReviewsFound() {
		when(reviewRepository.findAll()).thenReturn(List.of());

		List<Review> reviews = reviewService.getAll();

		assertThat(reviews).isEmpty();
		verify(reviewRepository).findAll();
	}

}
