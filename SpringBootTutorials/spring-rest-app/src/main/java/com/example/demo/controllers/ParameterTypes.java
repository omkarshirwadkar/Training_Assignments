package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;

@RestController
public class ParameterTypes {
	
	@GetMapping("/query")
	public String queryParamDemo(@RequestParam String name, @RequestParam int age) {
		System.out.println("*** Query Parameters ***");
		return "Welcome: " + name + " and you are " + age + " years old. ";
	}
	
	@GetMapping("/path/{name}/{age}")
	public String pathParamDemo(@PathVariable String name, @PathVariable int age) {
		System.out.println("*** Path Parameters ***");
		return "Welcome: " + name + " and you are " + age + " years old. ";
	}
	
	@GetMapping("/body")
	public String bodyParamDemo(@RequestBody Person p) {
		System.out.println("*** Path Parameters ***");
		return "Welcome: " + p.getName() + " and you are " + p.getAge() + " years old. ";
	}
	
	@GetMapping(path = "/persons", produces = "application/xml") // default is json
	public List<Person> getPerson() {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Omkar", 21));
		list.add(new Person("Rahul", 23));
		list.add(new Person("Sheetal", 11));
		list.add(new Person("Varshil", 41));
		list.add(new Person("Murari", 25));
		return list;
	}
}
