package com.example.application.service.client.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "localhost:8081", path = "/system/users")
//@RequestMapping("/system/users")
public interface UserClient {
    @GetMapping(value = "/{userId}")
    public UserResponse readById(@PathVariable("userId") Long userId);
}
