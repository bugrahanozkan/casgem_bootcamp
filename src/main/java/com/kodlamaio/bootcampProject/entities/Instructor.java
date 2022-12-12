package com.kodlamaio.bootcampProject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ınstructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User {

	

	private String companyName;
	
	@OneToMany(mappedBy = "instructor")
	private List<Bootcamps> bootcamps;


}
