package com.ezzerof.ordermanagementmicroservice.service.impl;

import com.ezzerof.ordermanagementmicroservice.exception.InvalidItemException;
import com.ezzerof.ordermanagementmicroservice.model.Item;
import com.ezzerof.ordermanagementmicroservice.repository.ItemRepository;
import com.ezzerof.ordermanagementmicroservice.service.ItemService;
import com.ezzerof.ordermanagementmicroservice.utils.ValidateObj;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        return repository.findById(itemId)
                .orElseThrow(() -> new InvalidItemException("Item does not exist"));
    }

    @Override
    public Item addItem(Item item) {
        ValidateObj.validateItem(item);
        return repository.save(item);
    }

    @Override
    public Item updateItem(Long itemId, Item updatedItem) {
        Optional<Item> exitingItem = repository.findById(itemId);
        if (exitingItem.isPresent() && updatedItem != null) {
            updatedItem.setItemId(itemId);
            return repository.save(updatedItem);
        }
        else
            throw new InvalidItemException("Item not found or invalid data");
    }

    @Override
    public void deleteItem(Long itemId) {
        if (repository.existsById(itemId))
            repository.deleteById(itemId);
        else
            throw new InvalidItemException("Item does not exist");
    }
}
