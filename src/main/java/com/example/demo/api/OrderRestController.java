package com.example.demo.api;


import com.example.demo.classes.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/orders")
public class OrderRestController {
    // This means to get the bean called orderRepository
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    // Map POST Request for adding orders to the MySQL Database
    @PostMapping(path="/add")
    public @ResponseBody String addOrder (@RequestBody Order order) {
        // Save to MySQL Repo
        orderService.saveOrder(order);
        return "";
    }

    // Map GET Request for receiving all information about users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
