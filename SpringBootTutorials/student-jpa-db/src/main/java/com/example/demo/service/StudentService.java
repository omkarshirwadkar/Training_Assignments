package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.repos.StudentDAO;

@Service
public class StudentService {

	@Autowired
	StudentDAO dao;
	
	public Iterable<Student> getStudents(){
		return dao.findAll();
	}
	
	public Optional<Student> findStudentByRollNo(int rollNo){
		return dao.findById(rollNo);
	}
	
	public String insertStudent(Student s){
		 if(dao.existsById(s.getRollNo())) {
			 return "sorry the Student already exists, choose another Roll No";
		 }
		dao.save(s);
		return "Added new Student Successfully !";
	}
	
	public String updateStudent(Student s, int rollNo) {
		 if(!dao.existsById(rollNo)) {
			 return "sorry the student does not exists, choose another rollNo to update";
		 }
		 dao.save(s);
		 return "Updated record successfully";
	 }
	
	 public String deleteStudent(int id) {
		 if(!dao.existsById(id)) {
			 return "sorry the Student does not exists, choose another rollNo to delete";
		 }
		 dao.deleteById(id);
		 return "Successfully deleted Student record !";
	 }
	 
	 public List<Student> findBySchool(String school){
		 return dao.findBySchool(school);
	 }
	 
	 public List<Student> getStudentsByResult(boolean pass) {
	        return pass ? dao.findPassedStudents() : dao.findFailedStudents();
	 }
	 
	 public long countByStd(int std) {
		 return dao.countByStd(std);
	 }
	 
	 public long countBySchool(String school) {
		 return dao.countBySchool(school);
	 }
	 
	 public List<Student> getToppers() {
	     return dao.findTop5ByPercentage();
	 }

	 public Student getTopperByStandard(int std) {
		 return dao.findTopperByStandard(std).orElse(null);
	 }
	 
	 public Optional<Teacher> findTeacherByRollNo(int rollNo){
		 return dao.findTeacherByRollNo(rollNo);
	 }
}
