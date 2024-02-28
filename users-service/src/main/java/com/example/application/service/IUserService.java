package com.example.application.service;

import com.example.application.model.response.UserResponse;

public interface IUserService {

    public UserResponse findById(Long id);

//    public UserRoleResponse findByEmail(String email);
}
