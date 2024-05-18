package com.example.application.service;

import com.example.application.model.domain.Person;
import com.example.application.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonReadService {
    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
