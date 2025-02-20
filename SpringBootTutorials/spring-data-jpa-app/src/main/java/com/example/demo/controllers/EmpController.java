package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmpDAO;

@RestController
public class EmpController {
	@Autowired
	EmpDAO dao;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return dao.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployees(@PathVariable int id) {
		return dao.findById(id);
	}
	
	@PostMapping("/employees")
	public String addEmployees(@RequestBody Employee e) {
		if (dao.existsById(e.getEid())){
			return "Employee already exists";
		}
		dao.save(e);
		return "Employee Added Successfully";
	}
	
//	@PutMapping("/employees/{id}")
//	public String updateEmployees(@RequestBody Employee e, @PathVariable int id) {
//		if (!dao.existsById(e.getEid())){
//			return "Employee does not exists";
//		}
//		dao.save(e);
//		return "Employee Updated Successfully";
//	}
	
	@RequestMapping(path = "/employees/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public String updateEmployee(@RequestBody Employee e, @PathVariable int id){
		if (!dao.existsById(id)){
			return "Employee does not exists";
		}
		dao.save(e);
		return "Employee Updated Successfully";
	}
	
	@DeleteMapping("/employees/{id}")
	public String removeEmployee(@PathVariable int id) {
		if (!dao.existsById(id)){
			return "Employee does not exists";
		}
		dao.deleteById(id);
		return "Employee Updated Successfully";
	}
	
	@GetMapping("/employees/role")
	public List<Employee> getEmployeeByDesig(String desig){
		return dao.getByDesignation(desig);
	}
	
	@GetMapping("/employees/above")
	public List<Employee> getEmployeeAbove(int age){
		return dao.findByAgeGreaterThan(age);
	}
	
	@GetMapping("/employees/below")
	public List<Employee> getEmployeeBelow(int age){
		return dao.findByAgeLessThan(age);
	}
	
	@GetMapping("/employees/custom")
	public List<Employee> getCustomQuery(String desig){
		return dao.myCustomQuery(desig);
	}
}
