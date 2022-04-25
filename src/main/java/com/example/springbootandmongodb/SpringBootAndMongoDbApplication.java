package com.example.springbootandmongodb;

import com.example.springbootandmongodb.persistence.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@EnableJpaRepositories(excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = UserRepository.class))
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootAndMongoDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAndMongoDbApplication.class, args);
    }


}
