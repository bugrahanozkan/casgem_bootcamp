package com.kodlamaio.bootcampProject.business.response.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetApplicationsResponse {
	private int id;

	private int userId;

	private int bootcampsId;

	private int state;
}
