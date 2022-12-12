package com.kodlamaio.bootcampProject.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	
 Instructor findInstructorByNationalIdendity(String nationalIdendity);
 
 Instructor getInstructorById(int id);
 
 List<Instructor> findByFirstName(String name);
	
	
}
