package com.kodlamaio.bootcampProject.business.response.blacklist;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistResponse {
private int id;

private LocalDate date;

private String reason;

private int applicantId;
}
