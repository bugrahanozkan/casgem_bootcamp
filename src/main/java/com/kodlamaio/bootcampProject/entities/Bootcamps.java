package com.kodlamaio.bootcampProject.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kodlamaio.bootcampProject.entities.applications.Applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bootcamps {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;

private LocalDate dateStart;

private LocalDate dateEnd;



private int state;

@ManyToOne()
@JoinColumn(name="instructor_id")
private Instructor instructor;

@OneToMany(mappedBy = "bootcamps")
private List<Applications> applications;


}
