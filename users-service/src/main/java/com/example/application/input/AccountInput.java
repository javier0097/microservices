package com.example.application.input;

import com.example.application.model.domain.AccountState;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AccountInput {
    private String avatarId;
    private AccountState accountState;
}
