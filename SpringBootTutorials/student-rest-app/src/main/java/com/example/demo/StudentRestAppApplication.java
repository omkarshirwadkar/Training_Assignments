package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Student;

@SpringBootApplication
public class StudentRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRestAppApplication.class, args);
//		List<Student> students = StudentLoader.loadStudents(50);
	}

}
