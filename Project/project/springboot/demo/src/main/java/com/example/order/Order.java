package com.example.order;

import java.util.Map;

public class Order {
    private Map<String, Integer> items;

    public Order() {
    }

    public Order(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
}
