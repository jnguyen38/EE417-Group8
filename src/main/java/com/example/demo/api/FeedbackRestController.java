package com.example.demo.api;


import com.example.demo.classes.Feedback;
import com.example.demo.classes.Order;
import com.example.demo.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/feedback")
public class FeedbackRestController {
    // This means to get the bean called orderRepository
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Map POST Request for adding orders to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody String addFeedback (@RequestBody Feedback feedback) {
        // Save to MySQL Repo
        feedbackRepository.save(feedback);
        return "Saved";
    }

    // Map GET Request for receiving all information about users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
