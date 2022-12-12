package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.GetEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.response.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface EmployeeService {

	DataResult<List<GetAllEmployeeResponse>> getAll();

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);


	
	DataResult<List<GetAllEmployeeResponse>>  getByName(GetEmployeeRequest request);

	DataResult<GetEmployeeResponse> getById(int id);

	Result deleteEmployeeById(int id);

	DataResult<UpdateEmployeeResponse> uptadeEmployeeById(UpdateEmployeeRequest updateEmployeeRequest);
}
