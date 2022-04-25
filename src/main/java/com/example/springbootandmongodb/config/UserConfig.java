package com.example.springbootandmongodb.config;

import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            List<User> users = Arrays.asList(
                    new User("Amadis", "amadis@test6.pt"),
                    new User("joão souza", "js@test7.pt")

            );
            //userRepository.saveAll(users);
        };
    }
}
