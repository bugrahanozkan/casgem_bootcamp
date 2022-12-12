package com.kodlamaio.bootcampProject.business.request.blacklist;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {

	@NotNull(message = Messages.IdBlankException)
	private int id;

	@NotNull(message = Messages.IdBlankException)
	private int applicantId;

	private String reason;

	@NotNull(message = Messages.DateBlankException)
	private LocalDate date;
}
