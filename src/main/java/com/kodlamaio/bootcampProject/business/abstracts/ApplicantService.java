package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.GetApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.response.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {

	 DataResult<List<GetAllApplicantResponse>> getAll();
	 
	 DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);
	 
	
	 
	 DataResult<GetApplicantResponse> getById(int id);
	 
	 
	 DataResult<List<GetAllApplicantResponse>>  getByName(GetApplicantRequest request);
	 
	 Result deleteApplicantById (int id);

	 
	 DataResult<UpdateApplicantResponse> uptadeApplicantById(UpdateApplicantRequest createApplicantRequest);
}
