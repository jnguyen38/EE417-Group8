package com.example.demo.api;


import com.example.demo.classes.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/orders")
public class OrderRestController {
    // This means to get the bean called orderRepository
    @Autowired
    private OrderRepository orderRepository;
    // Map POST Request for adding orders to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody Integer addOrder (@RequestBody Order order) {
        // Save to MySQL Repo
        orderRepository.save(order);
        return order.getId();
    }

    // Map GET Request for receiving all information about users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(path="/find/{id}")
    public @ResponseBody Optional<Order> findOrderById(@PathVariable Integer id) {
        return orderRepository.findById(id);
    }
}
