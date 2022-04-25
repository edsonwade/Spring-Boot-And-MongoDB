package com.example.springbootandmongodb.service;

import com.example.springbootandmongodb.exception.UserNotFoundException;
import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return Optional.of(userRepository.findById(id)).
                orElseThrow(UserNotFoundException::new);

    }
}
