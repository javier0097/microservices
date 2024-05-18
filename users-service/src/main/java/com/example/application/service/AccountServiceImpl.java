package com.example.application.service;

import com.example.application.exceptions.AccountNotFoundException;
import com.example.application.input.AccountInput;
import com.example.application.model.domain.Account;
import com.example.application.model.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found by id: " + id));
    }
    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(AccountInput input) {
        Account instance = new Account();
        instance.setAccountState(input.getAccountState());
        instance.setAvatarId(input.getAvatarId());
        return accountRepository.save(instance);
    }
    @Override
    public Account update(Long id, AccountInput input) {
        Account instance = accountRepository.findById(id).orElse(null);
        if (instance != null) {
            instance.setAvatarId(input.getAvatarId());
            instance.setAccountState(input.getAccountState());
            instance = accountRepository.save(instance);
        }
        return instance;
    }
}
