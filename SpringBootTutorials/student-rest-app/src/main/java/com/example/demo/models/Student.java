package com.example.demo.models;

public class Student {
	private String name;
	private int rollNo;
	private int std;
	private String school;
	private float percentage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public Student(String name, int rollNo, int std, String school, float percentage) {
		this.name = name;
		this.rollNo = rollNo;
		this.std = std;
		this.school = school;
		this.percentage = percentage;
	}
	public Student() {
	}
	
}
