package com.kodlamaio.bootcampProject.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
Employee findEmployeeByNationalIdendity(String nationalIdendity);

List<Employee> findByFirstName(String name);

Employee getEmployeeById(int id);
}
