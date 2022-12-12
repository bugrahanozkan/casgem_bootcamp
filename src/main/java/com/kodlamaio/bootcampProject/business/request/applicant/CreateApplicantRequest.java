package com.kodlamaio.bootcampProject.business.request.applicant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {

	@NotNull(message = Messages.NameBlankException)
	private String firstName;

	@NotNull(message = Messages.NameBlankException)
	private String lastName;

	@NotNull(message = Messages.MailBlankException)
	@Email
	private String email;

	@NotNull(message = Messages.PasswordBlankException)
	private String password;

	private String about;

	@Size(min = 11, max = 11, message = Messages.NationalIdentityNumberSizeException)
	@NotNull(message = Messages.NationalIdentityBlankException)
	private String nationalIdendity;

	@NotNull(message = Messages.DateBlankException)
	private String dateOfBirth;
}
