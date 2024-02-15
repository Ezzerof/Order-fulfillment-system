package com.ezzerof.ordermanagementmicroservice.rest.controller;

import com.ezzerof.ordermanagementmicroservice.exception.InvalidItemException;
import com.ezzerof.ordermanagementmicroservice.persistance.entity.Item;
import com.ezzerof.ordermanagementmicroservice.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@AllArgsConstructor
public class ItemController {
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable Long itemId) {
        try {
            Item item = itemService.getItemById(itemId);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (InvalidItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        try {
            Item createdItem = itemService.addItem(item);
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        } catch (InvalidItemException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable Long itemId) {
        try {
            Item updatedItem = itemService.updateItem(itemId, item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } catch (InvalidItemException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        try {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
