package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping(path = "/", produces = "text/html") // default is html
	public String greet() {
		return "<html> <body> <h1>Hello, World!</h1><hr></hr><h3> Thank You</h3></body> </html>";
	}
	
//	@GetMapping("/greet")
//	public String greet() {
//		return "<h1>Have a good day!</h1>";
//	}
//	
	@GetMapping("/greet")
	public String xyz1() {
		return "<h1>Have a good day!: GET</h1>";
	}
	
	@PatchMapping("/greet")
	public String xyz2() {
		return "<h1>Have a good day!: Patch</h1>";
	}
	
	@PostMapping("/greet")
	public String xyz3() {
		return "<h1>Have a good day!: POST</h1>";
	}
	
	@PutMapping("/greet")
	public String xyz4() {
		return "<h1>Have a good day!: PUT</h1>";
	}
	
	@DeleteMapping("/greet")
	public String xyz5() {
		return "<h1>Have a good day!: DELETE</h1>";
	}
}
