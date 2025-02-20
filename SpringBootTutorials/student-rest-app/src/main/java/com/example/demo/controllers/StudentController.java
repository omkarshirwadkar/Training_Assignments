package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentLoader;
import com.example.demo.models.Student;

@RestController
public class StudentController {
	List<Student> students = StudentLoader.loadStudents(50);
	
	@GetMapping(path = "/students", produces = "application/json")
	public List<Student> allStudents() {
		return students;
	}
	
	@GetMapping("/student/{rollNo}")
	public Student getStudent(@PathVariable int rollNo) {
		if (rollNo > 0 && rollNo <= students.size()) {
			return students.get(rollNo - 1);
		}
		else{
			return null;
		}
	}
	
	@GetMapping("/students/school")
	public List<Student> studentBySchool(@RequestParam String school){
		List<Student> schoolStudents = new ArrayList<Student>();
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getSchool().equals(school)) {
				schoolStudents.add(students.get(i));
			}
		}
		return schoolStudents;
	}
	
	@GetMapping("/students/result")
	public List<Student> studentStatus(@RequestParam Boolean pass){
		List<Student> failStudents = new ArrayList<Student>();
		List<Student> passStudents = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getPercentage() < 40.00) {
				failStudents.add(students.get(i));
			}
			else {
				passStudents.add(students.get(i));
			}
		}
		if(pass) {
			return passStudents;
		}
		return failStudents;
	}
	
	@GetMapping("/students/{standard}/count")
	public int studentStandard(@PathVariable int standard) {
		int count = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getStd() == standard) {
				count++;
			}
		}
		return count;
	}
	
	@GetMapping("students/strength")
	public int getSchoolStrength(@RequestParam String school) {
		int count = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getSchool().equals(school)) {
				count++;
			}
		}
		return count;
	}

	@GetMapping("/students/toppers")
	public List<Student> getToppers() {
		List<Student> toppers = new ArrayList<Student>();
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getPercentage() > s2.getPercentage()) {
					return -1;
				}
				else if(s1.getPercentage() < s2.getPercentage()) {
					return 1;
				}
				else {
					return 0;
				}
			}
			});
		return toppers;
	}
	
	@GetMapping("/students/topper/{standard}")
	public Student getStandardTopper(@PathVariable int standard) {
		Student s = null;
		float maxMarks = 0;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getStd() == standard) {
				if(students.get(i).getPercentage() > maxMarks) {
					maxMarks = students.get(i).getPercentage();
					s = students.get(i);
				}
			}
		}
		return s;
	}
	
}
