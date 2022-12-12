package com.kodlamaio.bootcampProject.business.request.instructor;

import javax.validation.constraints.NotNull;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInstructorRequest {
	@NotNull(message = Messages.NameBlankException)
	private String firstName;
}
