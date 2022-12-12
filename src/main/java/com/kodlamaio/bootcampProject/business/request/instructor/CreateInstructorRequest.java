package com.kodlamaio.bootcampProject.business.request.instructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateInstructorRequest {

	@NotNull(message = Messages.NameBlankException)
	@Length(min = 3,message = Messages.NameLenghtException)
	private String firstName;

	@NotNull(message = Messages.NameBlankException)
	private String lastName;

	@NotNull(message = Messages.MailBlankException)
	@Email
	private String email;

	@NotNull(message = Messages.PasswordBlankException)
	private String password;

	@NotNull(message = Messages.CompanyNameException)
	private String companyName;

	@Size(min = 11, max = 11, message = Messages.NationalIdentityNumberSizeException)
	@NotNull(message = Messages.NationalIdentityBlankException)
	private String nationalIdendity;

	@NotNull(message = Messages.DateBlankException)
	private String dateOfBirth;

}
