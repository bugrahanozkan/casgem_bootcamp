package com.kodlamaio.bootcampProject.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.bootcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.GetApplicantRequest;
import com.kodlamaio.bootcampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.response.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v2/applicanties")
@AllArgsConstructor
public class ApplicantController {
	private ApplicantService applicantService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		return applicantService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateApplicantResponse> add(@Valid  @RequestBody CreateApplicantRequest createApplicantResponse) {
		
		return applicantService.add(createApplicantResponse);
	}

	@GetMapping("getByName")
	public DataResult<List<GetAllApplicantResponse>> getByName(@Valid @RequestBody GetApplicantRequest request){
		return applicantService.getByName(request);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	 public Result deleteApplicantById(@PathVariable  int id) {
		
		return this.applicantService.deleteApplicantById(id);
	 }
	@PutMapping("/updateById")
	 DataResult<UpdateApplicantResponse> uptadeApplicantById( @Valid @RequestBody UpdateApplicantRequest updateApplicantRequest) {
		 return applicantService.uptadeApplicantById(updateApplicantRequest);
	 }
}
