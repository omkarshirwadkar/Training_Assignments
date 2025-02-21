package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.primary.PrimaryPersonRepository;
import com.example.demo.repository.secondary.SecondaryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PrimaryPersonRepository primaryRepository;

    @Autowired
    private SecondaryPersonRepository secondaryRepository;

    @PostMapping
    public String addPerson(@RequestBody Person person) {
        // Save to Primary Database
        primaryRepository.save(person);

        // Save to Secondary Database
        secondaryRepository.save(person);

        return "Person saved in both databases!";
    }
}
