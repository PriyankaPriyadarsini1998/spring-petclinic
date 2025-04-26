package org.springframework.samples.petclinic.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.review.model.Review;

/**
 * Repository for Pet clinic Review
 *
 * @author PriyankaPriyadarsini
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
