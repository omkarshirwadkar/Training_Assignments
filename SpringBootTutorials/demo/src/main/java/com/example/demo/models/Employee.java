package com.example.demo.models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.models.laapy.Laptop;

@Component("empl")
public class Employee implements Person{
	@Value("Mohit")
	private String name;
	@Value("220000")
	private int salary;
	@Value("21")
	private int age;
	@Value("Programmer")
	private String designation;
	@Autowired
	private Address address;
	@Autowired
//	@Qualifier("mac")
	private Laptop laptop;
	
	public Employee() {
		System.out.println("Employee Object Created");
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", designation=" + designation + ", address=" + address + ", laptop=" + laptop + "]";
	}
}
