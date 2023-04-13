package com.example.demo.classes;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ElementCollection
    @MapKeyColumn(name = "item_name")
    private Map<String, Integer> items;

    public Order() {}

    public Order(Integer id, Map<String, Integer> items) {
        this.id = id;
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}
