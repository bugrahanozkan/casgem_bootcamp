package com.kodlamaio.bootcampProject.business.response.applicant;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
	
	private String nationalIdendity;
	private String dateOfBirth;
}
