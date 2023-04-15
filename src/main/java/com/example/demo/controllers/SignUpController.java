package com.example.demo.controllers;

import com.example.demo.classes.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Controller
public class SignUpController {
    @GetMapping("/signup.html")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup.html";
    }

    @PostMapping("/signup.html")
    public String signupSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        // Initialize GSON Object for JSON conversions
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the User Object to JSON format and create the httpEntity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(gson.toJson(user), headers);

        // ResOperation POST Request method for objects
        RestOperations restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/api/users/add", request, String.class);

        return "submitted.html";
    }
}
