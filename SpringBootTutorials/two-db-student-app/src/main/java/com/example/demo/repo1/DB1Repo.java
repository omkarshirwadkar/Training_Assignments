package com.example.demo.repo1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Student;

public interface DB1Repo extends JpaRepository<Student, Integer>{

}