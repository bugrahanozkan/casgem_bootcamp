package com.kodlamaio.bootcampProject.business.response.employee;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	public String position;
	private String nationalIdendity;
	private String dateOfBirth;
}
