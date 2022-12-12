package com.kodlamaio.bootcampProject.business.response.instructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
	private String nationalIdendity;
	private String dateOfBirth;
}
