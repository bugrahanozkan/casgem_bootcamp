package com.kodlamaio.bootcampProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Bootcamps;

public interface BootcampsRepository extends JpaRepository<Bootcamps, Integer>{
	
	Bootcamps getBootcampsById(int id);
}
