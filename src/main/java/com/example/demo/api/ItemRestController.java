package com.example.demo.api;

import com.example.demo.classes.Item;
import com.example.demo.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/items")
public class ItemRestController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addItem(@RequestBody Item item) {
        itemRepository.save(item);
        return "Saved";
    }

    @GetMapping(path="/getCost/{name}")
    public @ResponseBody Integer getCost(@PathVariable String name) {
        Item item = itemRepository.findByNameIs(name);
        return item.getCost();
    }
}
