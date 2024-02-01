package com.example.application.controller;

import com.example.application.model.domain.Account;
import com.example.application.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/{accountId}")
    public Account getById(@PathVariable("accountId") Long accountId) {
        return accountService.findById(accountId);
    }

    @DeleteMapping(value = "/{accountId}")
    public void removeById(@PathVariable("accountId") Long accountId){
        accountService.deleteById(accountId);
    }
}
