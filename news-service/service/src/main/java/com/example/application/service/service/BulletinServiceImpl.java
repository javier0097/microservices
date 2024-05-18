package com.example.application.service.service;

import com.example.application.api.input.WallMessageCreateInput;
import com.example.application.service.client.users.UserResponse;
import com.example.application.service.model.domain.Bulletin;
import com.example.application.service.repositories.BulletinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service("bulletinServiceRestTemplate")
@Slf4j
public class BulletinServiceImpl implements IBulletinService{

    @Autowired
    private BulletinRepository bulletinRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Bulletin save(Long userId, Long accountId, WallMessageCreateInput input) {
        Map<String, String> pathVariables = new HashMap();
        pathVariables.put("userId",userId.toString());

        UserResponse user = restTemplate.getForObject("http://localhost:8081/system/users/{userId}", UserResponse.class, pathVariables);

        if(null != user){
            log.info("rest template: User found with email {}", user.getEmail());
        }
        Bulletin instance = composeBulletinInstance(userId, accountId, input);
        if(CollectionUtils.isEmpty(input.getFileIds())){
            //TODO: implementation is pending
        }
        instance = bulletinRepository.save(instance);
//        instance.setPortUserService(user.getPort());
        return instance;
    }

    private Bulletin composeBulletinInstance(Long userId, Long accountId, WallMessageCreateInput input) {
        Bulletin instance = new Bulletin();
        instance.setAccountId(accountId);
        instance.setSenderUserId(userId);
        instance.setBody(input.getContent());
        return instance;
    }
}
