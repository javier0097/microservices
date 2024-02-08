package com.example.application.controller;

import com.example.application.model.domain.Person;
import com.example.application.service.PersonReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/persons")
public class PersonReadController {
    @Autowired
    private PersonReadService personReadService;

    @GetMapping(value = "/{personId}")
    public Person getById(@PathVariable("personId") Long personId) {
        return personReadService.findById(personId);
    }
}
