package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.applications.CreateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.request.applications.UpdateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.response.applications.CreateApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.UpdateApplicationsResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicationsService {
 DataResult<List<GetAllApplicationsResponse>> getAll();
	 
	 DataResult<CreateApplicationsResponse> add(CreateApplicationsRequest createApplicationsRequest);
	 
	 DataResult<GetAllApplicationsResponse> getByName(String name);
	 
	 DataResult<GetApplicationsResponse> getById(int id);
	 
	 
	 Result deleteById (int id);

	 
	 DataResult<UpdateApplicationsResponse> updateById(UpdateApplicationsRequest updateApplicationsRequest);
}
