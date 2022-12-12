package com.kodlamaio.bootcampProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
