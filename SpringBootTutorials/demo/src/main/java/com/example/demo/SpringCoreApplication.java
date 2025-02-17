package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringCoreApplication {
	public static void main(String args[]) {
		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class);
		
		Object obj = ctx.getBean("emp_s");
		Object obj2 = ctx.getBean("std");
		
		System.out.println(obj);
		System.out.println(obj2);
	}
}
