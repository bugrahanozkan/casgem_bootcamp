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

import com.kodlamaio.bootcampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.GetEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.response.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v2/employees/")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;

	@GetMapping("getAll")
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		return this.employeeService.getAll();
	}

	@PostMapping("add")
	public DataResult<CreateEmployeeResponse> add(@Valid @RequestBody CreateEmployeeRequest createEmployeeResponse) {
		return this.employeeService.add(createEmployeeResponse);
	}

	@GetMapping("getAllByName")
	public DataResult<List<GetAllEmployeeResponse>>  getByName(@Valid @RequestBody GetEmployeeRequest request){
		return employeeService.getByName(request);
	}

	@GetMapping("getById/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return this.employeeService.getById(id);
	}
	
	@DeleteMapping("deleteById/{id}")
	 public Result deleteEmployeeById (@PathVariable  int id) {
		return this.employeeService.deleteEmployeeById(id);
		
	 }
	@PutMapping("uptadeById")
	 DataResult<UpdateEmployeeResponse> uptadeEmployeeById(@Valid @RequestBody UpdateEmployeeRequest request) {
		 return this.employeeService.uptadeEmployeeById(request);
	 }
}
