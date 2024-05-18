package com.example.application.service;

import com.example.application.model.domain.Person;
import com.example.application.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonReadByFirstNameAndLastNameService {

    @Autowired
    private PersonRepository personRepository;

//    public List<Person> find(String firstName, String lastName){
//       return personRepository.findByFirstNameAndLastNameOrderByCreatedDateDesc(firstName,lastName);
//    }

    public List<Person> find(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastNameOrdered(firstName, lastName);
    }
}
