package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/order")
    public void placeOrder(@RequestBody Order order) {
        System.out.println("Received order: " + order.getItems());
        orderService.saveOrder(order);
    }

}
