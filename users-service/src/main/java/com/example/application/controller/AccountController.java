package com.example.application.controller;

import com.example.application.input.AccountInput;
import com.example.application.model.domain.Account;
import com.example.application.service.IAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure/accounts")
@Tag(name="Account controller endpoints", description = "All endpoints in Account controller")
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
    @GetMapping
    public List<Account> list() {
        return accountService.findAll();
    }
    @PostMapping
    public Account createAccount(@RequestBody AccountInput input) {
        return accountService.save(input);
    }

    @PutMapping(value = "/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId, @RequestBody AccountInput input) {
        return accountService.update(accountId, input);
    }
}
