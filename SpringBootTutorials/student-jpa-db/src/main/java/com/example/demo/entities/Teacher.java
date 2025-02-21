package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	@Id
	private int std;
	private String name;
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
