package com.example.demo.models.laapy;

import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
@Priority(value = 1)
public class MacBook implements Laptop {

	@Override
	public String toString() {
		return "MacBook";
	}

}
