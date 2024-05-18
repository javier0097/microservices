package com.example.application.service;

import com.example.application.exceptions.PasswordInvalidException;
import com.example.application.input.PersonCreateInput;
import com.example.application.model.domain.Account;
import com.example.application.model.domain.AccountState;
import com.example.application.model.domain.Person;
import com.example.application.model.repositories.AccountRepository;
import com.example.application.model.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonCreateService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonRepository personRepository;
    public Person save(PersonCreateInput input) {
        Account account = composeAccount();
        account = accountRepository.save(account);
        if(!input.getPassword().equals(input.getConfirmPassword())){
            throw new PasswordInvalidException("Password not match");
        }
        Person person = composePerson(input, account);

        return personRepository.save(person);
    }

    private Account composeAccount() {
        Account instance = new Account();
        instance.setAccountState(AccountState.ACTIVATED);
        instance.setAvatarId("111");
        return instance;
    }

    private Person composePerson(PersonCreateInput input, Account account) {
        Person instance = new Person();
        instance.setFirstName(input.getFirstName());
        instance.setLastName(input.getLastName());
        instance.setEmail(input.getEmail());
        instance.setPassword(input.getPassword());
        instance.setAccount(account);
        return instance;
    }
}
