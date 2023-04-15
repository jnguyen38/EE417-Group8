package com.example.demo.controllers;

import com.example.demo.classes.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {
    @GetMapping(path="/order.html")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "order.html";
    }




}
