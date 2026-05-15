package com.ryan.demo.service;

import com.ryan.demo.model.User;
import com.ryan.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.getUser(id);
    }

    public User createUser(User user) {
        return  userRepository.createUser(user);
    }
    @PostConstruct
    public void init() {
        System.out.println("UserService initialized");
    }

}
