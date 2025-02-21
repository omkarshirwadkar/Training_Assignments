package com.example.demo.repository.secondary;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryPersonRepository extends JpaRepository<Person, Long> {
}
