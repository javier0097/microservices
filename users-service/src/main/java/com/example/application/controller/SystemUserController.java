package com.example.application.controller;

import com.example.application.model.response.UserResponse;
import com.example.application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/users")
public class SystemUserController {

    @Autowired
    private IUserService service;

//    @Value("${server.port}")
//    private Integer port;

    @GetMapping(value = "/{userId}")
    public UserResponse readById(@PathVariable("userId") Long userId) {
        UserResponse user = service.findById(userId);
//        user.setPort(port);
        return user;
    }

//    @GetMapping
//    public UserRoleResponse readByEmail(@RequestParam("email") String email) {
//        return service.findByEmail(email);
//    }
}
