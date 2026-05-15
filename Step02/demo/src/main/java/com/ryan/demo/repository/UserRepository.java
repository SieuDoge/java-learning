package com.ryan.demo.repository;

import com.ryan.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> danhSach = new ArrayList<>();
    public UserRepository() {
        danhSach.add(new User(1, "Ryan"));
        danhSach.add(new User(2, "Huynh"));
    }
    public List<User> findAll() {
        return danhSach;
    }

    public User getUser(String id) {
        return danhSach.get(Integer.parseInt(id));
    }
    public User createUser(User user) {
        danhSach.add(user);
        return user;
    }
}