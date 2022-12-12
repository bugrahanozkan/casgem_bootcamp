package com.kodlamaio.bootcampProject.business.request.employee;

import javax.validation.constraints.NotNull;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetEmployeeRequest {
	@NotNull(message = Messages.NameBlankException)
	private String firstName;
}
