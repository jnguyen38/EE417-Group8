package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    @RequestMapping("/donate")
    public String donate() {
        return "donate";
    }
    @RequestMapping("/gallery")
    public String gallery() {
        return "gallery";
    }
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @RequestMapping("/menu")
    public String menu() {
        return "menu";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
