package com.example.application.service.service;

import com.example.application.api.input.WallMessageCreateInput;
import com.example.application.service.client.users.UserClient;
import com.example.application.service.client.users.UserResponse;
import com.example.application.service.model.domain.Bulletin;
import com.example.application.service.repositories.BulletinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Scope("prototype")
@Service
@Slf4j
public class BulletinServiceFeign implements IBulletinService{

    private Integer age;
    @Autowired
    private BulletinRepository bulletinRepository;

    @Autowired
    private UserClient userClient;

    @Override
    public Bulletin save(Long userId, Long accountId, WallMessageCreateInput input) {
        UserResponse user = userClient.readById(userId);

        if(null != user){
            log.info("Feign user: User found with email {}", user.getEmail());
        }
        Bulletin instance = composeBulletinInstance(userId, accountId, input);
        if(CollectionUtils.isEmpty(input.getFileIds())){
            //TODO: implementation is pending
        }
        instance = bulletinRepository.save(instance);
        instance.setPortUserService(user.getPort());

        return instance;
    }

    private Bulletin composeBulletinInstance(Long userId, Long accountId, WallMessageCreateInput input) {
//        if(input.getAge() != null){
//            age = input.getAge();
//        }
        Bulletin instance = new Bulletin();
        instance.setAccountId(accountId);
        instance.setSenderUserId(userId);
        instance.setBody(input.getContent());
        instance.setAge(age);
        return instance;
    }
}
