package com.kodlamaio.bootcampProject.api;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.bootcampProject.business.abstracts.ApplicationsService;
import com.kodlamaio.bootcampProject.business.request.applications.CreateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.request.applications.UpdateApplicationsRequest;
import com.kodlamaio.bootcampProject.business.response.applications.CreateApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.GetApplicationsResponse;
import com.kodlamaio.bootcampProject.business.response.applications.UpdateApplicationsResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2/applications")
@AllArgsConstructor
public class ApplicationsController {
	private ApplicationsService applicationsService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		return applicationsService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateApplicationsResponse> add(@RequestBody CreateApplicationsRequest createApplicationsResponse) {
		return applicationsService.add(createApplicationsResponse);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetApplicationsResponse> getById(@PathVariable int id) {
		return applicationsService.getById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@PathVariable int id) {
		return this.applicationsService.deleteById(id);
	}

	@PutMapping("/updateById")
	DataResult<UpdateApplicationsResponse> updateById(@RequestBody UpdateApplicationsRequest updateApplicationsRequest) {
		return applicationsService.updateById(updateApplicationsRequest);
	}
}
