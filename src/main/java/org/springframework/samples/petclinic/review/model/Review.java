package org.springframework.samples.petclinic.review.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Model for Reviews of the pet clinic
 *
 * @author Priyanka Priyadarsini
 */

@Data
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Author name is required")
	@Size(max = 100, message = "Author name must be at most 100 characters")
	private String author;

	@NotBlank(message = "Content is required")
	@Size(max = 500, message = "Content must be at most 500 characters")
	private String content;

	@Column(name = "created_at", nullable = false, updatable = false,
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime createdAt;

}
