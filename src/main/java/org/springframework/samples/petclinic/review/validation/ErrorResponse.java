package org.springframework.samples.petclinic.review.validation;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Error Response class for Pet clinic Review
 *
 * @author PriyankaPriyadarsini
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private List<Integer> timestamp;

	private String status;

	private int statusCode;

	private String message;

	private String path;

	public static ErrorResponse of(String message, String path, int statusCode, String status) {
		LocalDate now = LocalDate.now();
		return ErrorResponse.builder()
			.timestamp(List.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth()))
			.status(status)
			.statusCode(statusCode)
			.message(message)
			.path(path)
			.build();
	}

}
