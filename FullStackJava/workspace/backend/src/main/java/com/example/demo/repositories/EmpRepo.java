package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

}
