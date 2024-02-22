package com.example.application.controller;


import com.example.application.model.domain.Person;
import com.example.application.service.PersonReadByFirstNameAndLastNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secure/persons")
public class PersonReadByFirstNameAndLastNameController {

    @Autowired
    private PersonReadByFirstNameAndLastNameService service;

    @GetMapping(value = "/search")
    public List<Person> search(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return service.find(firstName, lastName);
    }
}
