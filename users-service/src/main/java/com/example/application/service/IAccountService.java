package com.example.application.service;

import com.example.application.model.domain.Account;

public interface IAccountService {
    public Account findById(Long id);
    public void deleteById(Long id);
}
