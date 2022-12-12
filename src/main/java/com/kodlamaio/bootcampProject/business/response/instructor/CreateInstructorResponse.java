package com.kodlamaio.bootcampProject.business.response.instructor;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
	private String nationalIdendity;
	private String dateOfBirth;
}
