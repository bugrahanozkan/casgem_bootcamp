package com.kodlamaio.bootcampProject.business.concretes;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.GetEmployeeRequest;
import com.kodlamaio.bootcampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.response.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapper.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.EmployeeRepository;
import com.kodlamaio.bootcampProject.entities.Employee;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService{
  
	private EmployeeRepository employeeRepository;
	private ModelMapperService mapperService;
	
	
	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		//List<GetAllEmployeeResponse> responseList = new ArrayList<>();41.satır bunun işini yapıyor.
		/*
		 * for (Employee employee : employees) { GetAllEmployeeResponse response=
		 * mapperService.forResponse().map(employee, GetAllEmployeeResponse.class);
		 * responseList.add(response); }
		 */
		List<GetAllEmployeeResponse> response=employees.stream().map(employee -> mapperService.forResponse()
				.map(employee, GetAllEmployeeResponse.class))
		.collect(Collectors.toList()); 
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response,Messages.EmployeeGetALL);
		}
	

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		
		checkIfEmployeeExistsByNationalIdendity(createEmployeeRequest.getNationalIdendity());
		
		Employee employee = this.mapperService.forRequest().map(createEmployeeRequest, Employee.class);
		employee.setId(0);

		this.employeeRepository.save(employee);

		CreateEmployeeResponse createEmployeeResponse = this.mapperService.forResponse().map(employee, CreateEmployeeResponse.class);

		return new SuccessDataResult<>(createEmployeeResponse,Messages.EmployeeAdd);
	}


	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		checkIfEmployeeExistsById(id);
		Employee employee= this.employeeRepository.findById(id).get();
		GetEmployeeResponse response= this.mapperService.forResponse().map(employee,GetEmployeeResponse.class);
		
		return new SuccessDataResult<GetEmployeeResponse>(response);
	}

	@Override
	public Result deleteEmployeeById(int id) {
		checkIfEmployeeExistsById(id);
		employeeRepository.deleteById(id);
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> uptadeEmployeeById(UpdateEmployeeRequest updateEmployeeRequest) {
		
		
		checkIfEmployeeExistsById(updateEmployeeRequest.getId());
		
		Employee employee= this.mapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		
		//checkIfEmployeeExistsByNationalIdendity(updateEmployeeRequest.getNationalIdendity());

		this.employeeRepository.save(employee);
		
		UpdateEmployeeResponse updateEmployeeResponse = this.mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);


		return new SuccessDataResult<>(updateEmployeeResponse,Messages.EmployeeUpdate);
	}
	
	
	private void checkIfEmployeeExistsByNationalIdendity(String nationalIdendity) {
		Employee employee=this.employeeRepository.findEmployeeByNationalIdendity(nationalIdendity);
		if(employee!=null) {
			throw new BusinessException(Messages.EmployeeIdendityError);
		}
	}
	
	private void checkIfEmployeeExistsById(int id) {
		Employee employee = this.employeeRepository.findById(id).orElse(null);
		if(employee==null) {
			throw new BusinessException(Messages.EmployeeNotId);
		}
	}


	@Override
	public DataResult<List<GetAllEmployeeResponse>> getByName(GetEmployeeRequest request) {
		List<Employee> employee = employeeRepository.findByFirstName(request.getFirstName());
		List<GetAllEmployeeResponse> response = employee
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response,"findByName");
	}

}
