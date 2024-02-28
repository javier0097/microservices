package com.example.application.service.service;
import com.example.application.api.input.WallMessageCreateInput;
import com.example.application.service.model.domain.Bulletin;
public interface IBulletinService {
    public Bulletin save(Long userId, Long accountId, WallMessageCreateInput input);
}
