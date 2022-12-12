package com.kodlamaio.bootcampProject.business.request.applications;

import javax.validation.constraints.NotNull;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationsRequest {
	@NotNull(message=Messages.IdBlankException)
	private int userId;
	
	@NotNull(message = Messages.IdBlankException)
	private int bootcampsId;

	@NotNull(message = Messages.StateBlankException)
	private int state;
}
