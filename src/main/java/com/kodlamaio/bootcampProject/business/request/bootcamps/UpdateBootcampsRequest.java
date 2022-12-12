package com.kodlamaio.bootcampProject.business.request.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBootcampsRequest {

	@NotNull(message = Messages.IdBlankException)
	private int id;

	@NotNull(message = Messages.NameBlankException)
	private String name;

	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateStart;

	@NotNull(message = Messages.DateBlankException)
	private LocalDate dateEnd;

	@NotNull(message = Messages.IdBlankException)
	private int instructorId;

	@NotNull(message = Messages.StateBlankException)
	private int state;
}
