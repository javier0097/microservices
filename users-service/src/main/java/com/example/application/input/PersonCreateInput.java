package com.example.application.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonCreateInput {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;
}
