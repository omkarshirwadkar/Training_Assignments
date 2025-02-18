package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EmpConfiguration {
	@Bean("newemp")
	@Scope("prototype")
	public Employee getEmployee(String designation) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter Name: ");
	        String name = br.readLine();
	        System.out.println("Enter Age: ");
	        int age = Integer.parseInt(br.readLine());
	        System.out.println("Enter Salary: ");
	        int salary = Integer.parseInt(br.readLine());
	        return new Employee(name, age, salary, designation, getAddress());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Bean("empadd")
	@Scope("prototype")
	public Address getAddress() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter City:");
	        String city = br.readLine();
	        System.out.println("Enter State:");
	        String state = br.readLine();
	        System.out.println("Enter Pincode:");
	        int pincode = Integer.parseInt(br.readLine());
	        return new Address(city, state, pincode);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
