package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.Student;
import com.example.models.Address;
import com.example.models.Employee;

@Configuration
public class MyJavaConfiguration {

	@Bean("emp_c")
	@Scope("prototype")
	// Constructor Injection
	public Employee getEmployee() {
		return new Employee("Omkar", 21, 100000, "Programmer", getAddress());
	}
	
	@Bean("std")
	public Student getStudent() {
		return new Student();
	}
	
	@Bean("addr_c")
	public Address getAddress() {
		return new Address("Mumbai", "Maharashtra", 400064);
	}
	
	@Bean("emp_s")
	public Employee getEmployee2() {
		Employee e = new Employee();
		e.setName("Lohar");
		e.setAge(21);
		e.setSalary(100000);
		e.setDesignation("Tester");
		e.setAddress(getAddress2());
		return e;
	}
	
	@Bean("addr_s")
	public Address getAddress2() {
		Address a = new Address();
		a.setCity("Pune");
		a.setState("Maharashtra");
		a.setPin(400768);
		return a;
	}
}
