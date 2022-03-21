package com.example.springbootandmongodb.controller;


import com.example.springbootandmongodb.exception.UserNoFoundException;
import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.listAllUsers();
        return (users != null) ? ResponseEntity.ok().body(users) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }


}
