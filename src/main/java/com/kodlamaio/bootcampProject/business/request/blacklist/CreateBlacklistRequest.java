package com.kodlamaio.bootcampProject.business.request.blacklist;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.kodlamaio.bootcampProject.business.constants.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBlacklistRequest {
	
	@NotNull(message = Messages.IdBlankException)
 private int applicantId;
 
 private String reason;
 
 @NotNull(message = Messages.DateBlankException)
 private LocalDate date;
}
