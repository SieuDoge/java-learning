package com.ryan.demo.controller;

import com.ryan.demo.model.User;
import com.ryan.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUser();
        if (users != null) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/users")

    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userService.createUser(user);
        return ResponseEntity.status(201).body(user);
    }
}


