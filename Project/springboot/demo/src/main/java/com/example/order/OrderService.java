package com.example.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private static final String ORDERS_FILE = "orders.json";

    public void saveOrder(Order order) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> orders = getOrders();
        orders.add(order);

        try {
            File file = new File(ORDERS_FILE);
            objectMapper.writeValue(file, orders);
        } catch (IOException e) {
            throw new RuntimeException("Error saving order", e);
        }
    }

    public List<Order> getOrders() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> orders = new ArrayList<>();

        try {
            File file = new File(ORDERS_FILE);
            if (file.length() != 0) {
                orders = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Order.class));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading orders", e);
        }

        return orders;
    }
}
