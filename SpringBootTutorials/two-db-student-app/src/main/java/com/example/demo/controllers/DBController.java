package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.repo1.DB1Repo;
import com.example.demo.repo2.DB2Repo;

import jakarta.transaction.Transactional;


@RestController
public class DBController {
     
	@Autowired
	DB1Repo db1;
	
	@Autowired
	DB2Repo db2;
	
	@Transactional
	@PostMapping("/student")
	  public String addEmployees(@RequestBody Student s)
	  {    
	    db1.save(s);
	    db2.save(s);
	    
	    return "Student added succesfully"; 
		
	  }
	
}