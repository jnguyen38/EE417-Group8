package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {
    @RequestMapping("index.html")
    public String index() {
        return "index.html";
    }
    @RequestMapping("about.html")
    public String about() {
        return "about.html";
    }
    @RequestMapping("donate.html")
    public String donate() {
        return "donate.html";
    }
    @RequestMapping("gallery.html")
    public String gallery() {
        return "gallery.html";
    }
    @RequestMapping("contact.html")
    public String contact() {
        return "contact.html";
    }
    @RequestMapping("register.html")
    public String register() {
        return "register.html";
    }
    @RequestMapping("menu.html")
    public String menu() {
        return "menu.html";
    }
    @RequestMapping("admin.html")
    public String admin() {
        return "admin.html";
    }
    @RequestMapping("news.html")
    public String news() {
        return "news.html";
    }
    @RequestMapping("branches.html")
    public String branches() {
        return "branches.html";
    }
    @GetMapping ("order.html")
    public String order() {
        return "order.html";
    }
    @GetMapping ("feedback.html")
    public String feedback() {
        return "feedback.html";
    }
    @GetMapping ("submitted.html")
    public String submitted() {
        return "submitted.html";
    }
}
