package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.GetInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.response.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;



public interface InstructorService {
	
	
	DataResult<List<GetAllInstructorResponse>> getAll();

	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);

	 DataResult<List<GetAllInstructorResponse>> findByName(GetInstructorRequest request);

	DataResult<GetInstructorResponse> getById(int id);

	Result deleteInstructorById(int id);
//UptadeInstructorResponse 
	DataResult<UpdateInstructorResponse> updateInstructorById(UpdateInstructorRequest updateInstructorRequest);
}
