package com.example.demo.services;

import com.example.demo.classes.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        User newUser = new User(
                user.getId(),
                user.getRole(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getNumber(),
                user.getAddress(),
                user.getEircode(),
                passwordEncoder.encode(user.getPassword())
                );
        userRepository.save(newUser);
    }

    @Override
    public User findByEmailIs(String email) {
        return userRepository.findByEmailIs(email);
    }
}