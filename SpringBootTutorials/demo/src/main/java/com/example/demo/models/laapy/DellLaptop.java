package com.example.demo.models.laapy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Priority(value = 2)
public class DellLaptop implements Laptop {

	@Override
	public String toString() {
		return "DellLaptop";
	}

}
