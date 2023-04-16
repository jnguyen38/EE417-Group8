package com.example.demo.controllers;

import com.example.demo.classes.Contact;
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
public class ContactController {
    @GetMapping("/contact.html")
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping("/contact.html")
    public String contactSubmit(@ModelAttribute Contact contact, Model model) {
        model.addAttribute("contact", contact);

        // Initialize GSON Object for JSON conversions
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the User Object to JSON format and create the httpEntity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(gson.toJson(contact), headers);

        // ResOperation POST Request method for objects
        RestOperations restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8080/api/contacts/add", request, String.class);

        return "submitted.html";
    }
}
