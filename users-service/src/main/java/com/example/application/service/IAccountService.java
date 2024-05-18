package com.example.application.service;

import com.example.application.input.AccountInput;
import com.example.application.model.domain.Account;

import java.util.List;

public interface IAccountService {
    public Account findById(Long id);
    public void deleteById(Long id);
    public List<Account> findAll();
    public Account save(AccountInput input);
    public Account update(Long id, AccountInput input);
}
