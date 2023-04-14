package com.example.demo.controllers;

import com.example.demo.classes.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/signin")
    public String signinForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }
}
