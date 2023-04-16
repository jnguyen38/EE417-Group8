package com.example.demo.api;

import com.example.demo.classes.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {

    // This means to get the bean called userRepository
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Map POST Request for adding to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody String addUser (@RequestBody User user) {
        // Save to MySQL Repo
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
        return "Saved";
    }

    // Map GET Request for receiving all information about users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Map GET Request for finding a specific user based on a Path Variable
    @GetMapping("/find/{username}")
    public @ResponseBody User findUser(@PathVariable String username){
        return userRepository.findByUsernameIs(username);
    }
}
