package com.devsu.client.services;

import com.devsu.client.models.Person;
import com.devsu.client.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> getAllPersons(){
        return this.personRepository.findAll();
    }
}
