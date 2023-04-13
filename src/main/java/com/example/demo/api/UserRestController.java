package com.example.demo.api;

import com.example.demo.classes.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {

    // This means to get the bean called userRepository
    @Autowired
    private OrderRepository userRepository;
    @Autowired
    private UserService userService;

    // Map POST Request for adding to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody String addUser (@RequestBody User user) {
        // Save to MySQL Repo
        userService.saveUser(user);
        return "Saved";
    }

    // Map GET Request for receiving all information about users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Map GET Request for finding a specific user based on a Path Variable
    @GetMapping("/find/{user}")
    public @ResponseBody User findUser(@PathVariable String user){
        return userRepository.findByUsernameIs(user);
    }
}
