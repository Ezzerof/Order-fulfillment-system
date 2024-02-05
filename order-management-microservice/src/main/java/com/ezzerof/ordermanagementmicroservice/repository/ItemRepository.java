package com.ezzerof.ordermanagementmicroservice.repository;

import com.ezzerof.ordermanagementmicroservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
