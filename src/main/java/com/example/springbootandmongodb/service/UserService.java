package com.example.springbootandmongodb.service;

import com.example.springbootandmongodb.dto.UserDTO;
import com.example.springbootandmongodb.exception.UserNotFoundException;
import com.example.springbootandmongodb.persistence.model.User;
import com.example.springbootandmongodb.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return Optional.of(userRepository.findById(id)).
                orElseThrow(() -> new UserNotFoundException(" user with " + id + " not found "));

    }

    public Optional<User> findByEmail(String email) {
        return Optional.of(userRepository.findByEmail(email).
                orElseThrow(() -> new UserNotFoundException(" user with email "
                        + email + " not found ")));

    }

    public User createNewUser(User user) {
        return userRepository.insert(user);
    }

    public User update(User user) {

        User users = userRepository.findUserById(user.getId());

        if (!(users.getId().equals(user.getId()))) {
            logger.error("user not exist " + users.getId());
            throw new UserNotFoundException(" user with id " + users.getId() + " no found ");
        }
        updateData(users, user);
        logger.info("user update with success " + users.getId() + users.getName() + users.getEmail());
        return userRepository.save(users);
    }

    public void updateData(User user, User newUser) {
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
    }

    public void deleteUser(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    /**
     * todo maintenance in future. coz right now this methods is break the solid principle.
     */
    public User fromDTO(@NotNull UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
