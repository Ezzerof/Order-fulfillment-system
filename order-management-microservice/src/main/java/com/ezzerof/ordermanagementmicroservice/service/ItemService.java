package com.ezzerof.ordermanagementmicroservice.service;

import com.ezzerof.ordermanagementmicroservice.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long itemId);
    Item addItem(Item item);
    Item updateItem(Long itemId, Item updatedItem);
    void deleteItem(Long itemId);
}
