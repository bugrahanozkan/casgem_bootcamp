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
import com.kodlamaio.bootcampProject.business.abstracts.BootcampsService;
import com.kodlamaio.bootcampProject.business.request.bootcamps.CreateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.request.bootcamps.UpdateBootcampsRequest;
import com.kodlamaio.bootcampProject.business.response.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetAllBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.GetBootcampsResponse;
import com.kodlamaio.bootcampProject.business.response.bootcamps.UpdateBootcampsResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2/bootcamps")
@AllArgsConstructor
public class BootcampsController {
	private BootcampsService bootcampsService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllBootcampsResponse>> getAll() {
		return bootcampsService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateBootcampResponse> add(@Valid @RequestBody CreateBootcampsRequest createBootcampsResponse) {

		return bootcampsService.add(createBootcampsResponse);
	}
	
	@GetMapping("/getById/{id}")
	public DataResult<GetBootcampsResponse> getById(@PathVariable int id) {
		return bootcampsService.getById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	 public Result deleteById(@PathVariable  int id) {
		
		return this.bootcampsService.deleteById(id);
	 }
	
	@PutMapping("/updateById")
	DataResult<UpdateBootcampsResponse> updateById(@Valid @RequestBody UpdateBootcampsRequest updateBootcampsRequest) {
		return bootcampsService.updateById(updateBootcampsRequest);
	}
}
