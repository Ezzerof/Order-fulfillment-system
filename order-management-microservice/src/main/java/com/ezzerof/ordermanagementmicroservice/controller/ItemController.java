package com.ezzerof.ordermanagementmicroservice.controller;

import com.ezzerof.ordermanagementmicroservice.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @GetMapping
    public List<Item> getAllItems() {
        return null;
    }

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable Long itemId) {
        return null;
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return null;
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@RequestBody Item item, @PathVariable Long itemId) {
        return null;
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {

    }
}
