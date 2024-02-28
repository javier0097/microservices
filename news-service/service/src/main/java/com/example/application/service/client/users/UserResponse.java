package com.example.application.service.client.users;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserResponse {

    private Long userId;

    private Long accountId;

    private String name1;

    private String name2;

    private String avatarId;

    private String email;

    private UserType userType;

    private Date createdDate;

    private Integer port;
}
