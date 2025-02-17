package com.example.demo.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee implements Person {
	@Value("Mohit")
	private String name;
	@Value("220000")
	private int salary;
	@Value("21")
	private int age;
	@Value("Programmer")
	private String designation;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", designation=" + designation + "]";
	}
}
