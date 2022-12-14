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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootcampProject.business.request.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.GetInstructorRequest;
import com.kodlamaio.bootcampProject.business.request.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.response.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.response.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2/instructors")
@AllArgsConstructor
public class InstructorController {
	private InstructorService instructorService;

	@GetMapping("/getAll")
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		return this.instructorService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateInstructorResponse> add(@Valid @RequestBody CreateInstructorRequest createInstructorRequest) {
		return instructorService.add(createInstructorRequest);
	}


	@GetMapping("getAllByName")
	public DataResult<List<GetAllInstructorResponse>>  findByName(@Valid @RequestBody GetInstructorRequest request){
		return instructorService.findByName(request);
	}

	@GetMapping("/getById/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id) {
		return this.instructorService.getById(id);
	}

	@DeleteMapping("/deleteById/{id}")
	public Result deleteInstructorById(@PathVariable int id) {
		return this.instructorService.deleteInstructorById(id);
	}

	@PutMapping("/update")
	public DataResult<UpdateInstructorResponse> updateInstructorById( @Valid @RequestBody UpdateInstructorRequest request) {

		return this.instructorService.updateInstructorById(request);
	}
}
