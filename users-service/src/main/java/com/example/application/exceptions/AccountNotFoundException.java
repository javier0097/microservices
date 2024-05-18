package com.example.application.exceptions;

public class AccountNotFoundException extends ApplicationException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}
