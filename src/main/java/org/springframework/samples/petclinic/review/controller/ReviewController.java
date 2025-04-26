package org.springframework.samples.petclinic.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.review.model.Review;
import org.springframework.samples.petclinic.review.service.ReviewService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * Controller class for Pet clinic Review
 *
 * @author PriyankaPriyadarsini
 */
@RestController
@RequestMapping("/reviews")
@Validated
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public ResponseEntity<Review> createReview(@Valid @RequestBody Review review) {
		Review saved = reviewService.save(review);
		return ResponseEntity.ok(saved);
	}

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews() {
		return ResponseEntity.ok(reviewService.getAll());
	}

}
