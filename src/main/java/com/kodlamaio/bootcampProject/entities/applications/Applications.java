package com.kodlamaio.bootcampProject.entities.applications;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kodlamaio.bootcampProject.entities.Applicant;
import com.kodlamaio.bootcampProject.entities.Bootcamps;
import com.kodlamaio.bootcampProject.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applications {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private int state;

@ManyToOne
@JoinColumn(name="user_id")
private User user;


@ManyToOne
@JoinColumn(name="bootcamp_id")
private Bootcamps bootcamps;



}
