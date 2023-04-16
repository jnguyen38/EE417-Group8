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
    // This means to get the bean called feedbackRepository
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Map POST Request for adding feedback to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody Integer addFeedback (@RequestBody Feedback feedback) {
        // Save to MySQL Repo
        feedbackRepository.save(feedback);
        return feedback.getId();
    }

    // Map GET Request for receiving all information about feedback
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
