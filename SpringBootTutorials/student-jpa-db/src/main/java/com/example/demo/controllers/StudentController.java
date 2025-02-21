package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	
	@GetMapping("/students")
	public Iterable<Student> getStudents(){
		return service.getStudents();
	}
	
	@GetMapping("/students/{rollNo}")
	public Optional<Student> getStudentByRollNo(@PathVariable int rollNo){
		return service.findStudentByRollNo(rollNo);
	}
	
	@PostMapping("/students/create")
	public String insertStudent(@RequestBody Student s) {
		return service.insertStudent(s);
	}
	
	 @RequestMapping(path = "students/update/{rollNo}",method = {RequestMethod.PUT,RequestMethod.PATCH})
	 public String updateStudent(@RequestBody Student s, @PathVariable int rollNo ) {
		 return service.updateStudent(s, rollNo);
	 }
	 
	 @DeleteMapping("/students/remove/{rollNo}")
	 public String deleteEmployee(@PathVariable int rollNo ) {
		 return service.deleteStudent(rollNo);
	 }
	 
	 @GetMapping("/students/school")
	 public List<Student> findBySchool(String school){
		 return service.findBySchool(school);
	 }
	 @GetMapping(path="/students/result",produces="application/json")
		public List<Student> getStudentByResult(@RequestParam boolean pass) {
			 return service.getStudentsByResult(pass);
		}
	 
	 @GetMapping("/students/{std}/count")
	 public long countByStandard(@PathVariable int std) {
		 return service.countByStd(std);
	 }
	 
	 @GetMapping("/students/strength")
	 public long countBySchool(String school) {
		 return service.countBySchool(school);
	 }
	 
	 @GetMapping(path="/students/toppers",produces="application/json")
	 public List<Student> getToppers() {
		 return service.getToppers();
	 }
		
	 
	 @GetMapping(path="/students/topper/{std}",produces="application/json")
	 public Student getTopperByStandard(@PathVariable int std) {
		 return service.getTopperByStandard(std);
	 }
	 
	 @GetMapping("/students/class_teacher")
	 public Optional<Teacher> getTeacherByRollNo(@RequestParam int rollNo) {
		 return service.findTeacherByRollNo(rollNo);
	 }
}
