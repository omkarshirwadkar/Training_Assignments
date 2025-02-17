package com.example.demo.models.laapy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;

@Component
//@Primary
@Priority(value = 3)
public class LenovoLaptop implements Laptop {

	@Override
	public String toString() {
		return "LenovoLaptop";
	}

}
