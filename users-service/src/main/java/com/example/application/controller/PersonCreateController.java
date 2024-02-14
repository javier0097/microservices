package com.example.application.controller;

import com.example.application.input.PersonCreateInput;
import com.example.application.model.domain.Person;
import com.example.application.service.PersonCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/accounts")
public class PersonCreateController {
    @Autowired
    private PersonCreateService personCreateService;
    @PostMapping
    public Person createPerson(@RequestBody PersonCreateInput input){
        return personCreateService.save(input);
    }
}
