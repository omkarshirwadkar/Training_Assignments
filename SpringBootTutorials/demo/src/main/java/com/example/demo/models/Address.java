package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String city;
	private String country;
	private int pincode;

	public Address() {
		System.out.println("From Address Constructor");
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
