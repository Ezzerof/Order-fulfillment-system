package com.ezzerof.ordermanagementmicroservice.persistance.repository;

import com.ezzerof.ordermanagementmicroservice.persistance.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
