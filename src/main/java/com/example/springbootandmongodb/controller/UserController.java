package com.example.springbootandmongodb.controller;


import com.example.springbootandmongodb.dto.UserDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(path= "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping(value = "users")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<User> users = userService.listAllUsers();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).toList();
        return (userDTOS != null) ? ResponseEntity.ok().body(userDTOS) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }


}
