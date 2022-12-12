package com.kodlamaio.bootcampProject.business.request.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampsRequest {
	@NotNull(message = Messages.NameBlankException)
	@Length(min=3,message=Messages.NameLenghtException)
	private String name;
	
	
@NotNull(message = Messages.DateBlankException)
	private LocalDate dateStart;


@NotNull(message = Messages.DateBlankException)
	private LocalDate dateEnd;


@NotNull(message = Messages.DateBlankException)
	private int instructorId;

	
	@NotNull(message = Messages.StateBlankException)
	private int state;
}
