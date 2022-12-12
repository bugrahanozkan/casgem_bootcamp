package com.kodlamaio.bootcampProject.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Blacklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private LocalDate date;

private String reason;

@ManyToOne
@JoinColumn(name="applicant_id")
private Applicant applicant;
}
