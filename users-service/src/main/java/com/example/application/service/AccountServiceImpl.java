package com.example.application.service;

import com.example.application.model.domain.Account;
import com.example.application.model.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
