package com.example.springbootandmongodb.dto;

import com.example.springbootandmongodb.persistence.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class UserDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserDTO() {
    }
}
