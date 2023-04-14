package com.example.demo.services;

import com.example.demo.classes.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
