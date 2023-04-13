package com.example.demo.services;

import com.example.demo.classes.User;

public interface UserService {
    void saveUser(User user);
    User findByUsernameIs(String username);

}