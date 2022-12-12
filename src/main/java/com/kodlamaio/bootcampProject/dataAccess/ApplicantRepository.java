package com.kodlamaio.bootcampProject.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	Applicant findApplicantByNationalIdendity(String nationalIdendity);

	List<Applicant> findByFirstName(String name);

	Applicant getApplicantById(int id);
}
