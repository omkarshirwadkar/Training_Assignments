package com.example.demo.repository.primary;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryPersonRepository extends JpaRepository<Person, Long> {
}
