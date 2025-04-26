package org.springframework.samples.petclinic.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.review.model.Review;
import org.springframework.samples.petclinic.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

/**
 * Service class for Pet clinic Review
 *
 * @author PriyankaPriyadarsini
 */
@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repo;

	public List<Review> getAll() {
		return repo.findAll();
	}

	public Review save(Review review) {
		return repo.save(review);
	}

}
