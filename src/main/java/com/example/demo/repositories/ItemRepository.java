package com.example.demo.repositories;

import com.example.demo.classes.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByNameIs(String name);
    Item getItemByNameIs(String name);
}
