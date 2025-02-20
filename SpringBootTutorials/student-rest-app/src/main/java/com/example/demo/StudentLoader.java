package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.models.Student;

public class StudentLoader {
	
	public static List<Student> loadStudents(int count){
		List<Student> students = new ArrayList<Student>();
        Random random = new Random();

        String[] names = {"Aarav", "Aditya", "Anika", "Aryan", "Diya", "Ishaan", "Neha", "Rahul", "Saanvi", "Vivaan",
                "Aanya", "Advik", "Anaya", "Arjun", "Dhruv", "Isha", "Nikhil", "Ria", "Samaira", "Yash",
                "Atharv", "Avyaan", "Bhavya", "Chaitanya", "Eesha", "Gaurav", "Harsh", "Jiya", "Kavya", "Laksh",
                "Manya", "Navya", "Om", "Pranav", "Rashi", "Shaurya", "Tanya", "Uday", "Vaishnavi", "Zayn",
                "Aarushi", "Abhay", "Akira", "Ansh", "Bhanu", "Charvi", "Dev", "Esha", "Faisal", "Grishma",
                "Himanshu", "Ishika", "Jay", "Kritika", "Lavanya", "Manav", "Naina", "Ojas", "Pari", "Reyansh",
                "Siddharth", "Trisha", "Utkarsh", "Vriti", "Yashika", "Anika", "Arush", "Avni", "Daksh",
                "Ekam", "Falak", "Hridhaan", "Ishaan", "Jahaan", "Kashvi", "Luv", "Maitri", "Nirvaan", "Oorja",
                "Prajwal", "Ria", "Samay", "Tia", "Urvashi", "Vihaan", "Yash", "Aarohi", "Adhiraaj", "Akshat",
                "Ananya", "Bhavin", "Chirag", "Dhairya", "Eshaan", "Falguni", "Gagan", "Harnoor", "Ishita",
                "Jatin", "Kripa", "Lisha", "Mayank", "Niharika", "Oshin", "Priyanka", "Rohan", "Srishti",
                "Tanishq", "Upendra", "Vanya", "Yug"}; // 100 names

        String[] schools = {"KV", "DPS", "SVV", "SRM", "WES", "RSV", "BOP"};

        for (int i = 0; i < count; i++) {
            String name = names[i % names.length]; // Cycle through names if count > names.length
            int rollNo = i + 1; // Simple roll number generation
            int standard = random.nextInt(12) + 1; // Standard between 1 and 12
            String school = schools[random.nextInt(schools.length)];
            float percentage = (float) (Math.round((random.nextFloat() * 100) * 100.0) / 100.0); // Percentage between 0 and 100, rounded to 2 decimal places

            students.add(new Student(name, rollNo, standard, school, percentage));
        }

        return students;
	}
}
