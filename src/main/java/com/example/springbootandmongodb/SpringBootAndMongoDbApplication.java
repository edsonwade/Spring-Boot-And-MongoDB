package com.example.springbootandmongodb;

import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.List;


@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@EnableJpaRepositories(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UserRepository.class))
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootAndMongoDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAndMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            //User user = new User("Vanilson wayne", "edson@edson.com");
            List<User> users = Arrays.asList(
                    new User("Mauro", "mauro@test1"),
                    new User("Rui Pinto", "ruipinto@test2"),
                    new User("Leonildo", "leonildo@example.com"),
                    new User("Nadia", "nadia@test3.ao")
            );
            userRepository.insert(users);
        };
    }
}
