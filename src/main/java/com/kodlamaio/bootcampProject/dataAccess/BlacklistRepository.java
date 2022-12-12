package com.kodlamaio.bootcampProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Blacklist;

public interface BlacklistRepository  extends JpaRepository<Blacklist, Integer>{

	Blacklist getBlacklistById(int id);
	
	boolean existsBlacklistByApplicantId(int userId);
}
