package com.example.demo.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student implements Person {
	
	// Example of Field Injection
	@Value("${rno}")
	private int rollNo;
	@Value("${sname}")
	private String name;
	@Value("${std}")
	private int standard;
	
	@Override
	public String toString() {
		return  "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + "]";
	}
}
