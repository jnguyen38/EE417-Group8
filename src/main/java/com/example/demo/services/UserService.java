package com.example.demo.services;

import com.example.demo.classes.User;

public interface UserService {
    void saveUser(User user);
    User findByEmailIs(String email);

}