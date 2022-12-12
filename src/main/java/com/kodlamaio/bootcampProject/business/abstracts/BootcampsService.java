package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.bootcamps.CreateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.request.bootcamps.UpdateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.response.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetAllBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.UpdateBootcampsResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BootcampsService {
	
 DataResult<List<GetAllBootcampsResponse>> getAll();
 
 DataResult<CreateBootcampResponse> add(CreateBootcampsRequest createBootcampsRequest);
 
 DataResult<GetAllBootcampsResponse> getByName(String name);
 
 DataResult<GetBootcampsResponse> getById(int id);
 
 Result deleteById(int id);
 
 DataResult<UpdateBootcampsResponse> updateById(UpdateBootcampsRequest updateBootcampsRequest);
 
 void checkIfBootcampIsActive(int id);
}
