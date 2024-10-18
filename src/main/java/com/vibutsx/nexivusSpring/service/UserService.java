package com.vibutsx.nexivusSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.UserEntity;

@Service
public interface UserService {
    UserEntity create(UserEntity entity);
    List<UserEntity> getAll();
    UserEntity getByUsername(String username);
    UserEntity update(Long id, UserEntity entity);
    void delete(Long id);
    UserEntity getById(Long id);
}
