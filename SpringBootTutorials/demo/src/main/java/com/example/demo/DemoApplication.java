package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Person;

import java.util.Scanner;

//import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		BeanFactory bf = SpringApplication.run(DemoApplication.class, args);
//		ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
//		System.out.println(bf + "/n" + ac);
		System.out.println("Welcome to Spring Boot");
		
//		Person p1 = bf.getBean(Employee.class);
		
//		System.out.println("Enter which object to create");
//		String obj = new Scanner(System.in).next();
		
//		The string passed should start with small letter
// 		The class called should have @Component can also pass the name
//		Person p1 = (Person) bf.getBean(obj);
		Person p2 = (Person) bf.getBean("emp");
		Person p3 = (Person) bf.getBean("student");
		System.out.println(p2);
		System.out.println(p3);
		
	}

}
