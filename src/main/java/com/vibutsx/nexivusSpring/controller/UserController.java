package com.vibutsx.nexivusSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vibutsx.nexivusSpring.entity.UserEntity;
import com.vibutsx.nexivusSpring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity>  users = userService.getAll();

        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity entity) {
        
        UserEntity newUser = userService.create(entity);
        
        return ResponseEntity.status(201).body(newUser);
    }
    
    
}
