package com.example.springbootandmongodb.service;

import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
