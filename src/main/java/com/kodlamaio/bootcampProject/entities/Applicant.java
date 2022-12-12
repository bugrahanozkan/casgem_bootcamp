package com.kodlamaio.bootcampProject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootcampProject.entities.applications.Applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {


	@Column(name = "about")
	private String about;
	
	/*@OneToMany(mappedBy = "applicant")
	private List<Blacklist> blacklists;
	
	@OneToMany(mappedBy = "applicant")
	private List<Applications> applications;*/


}
