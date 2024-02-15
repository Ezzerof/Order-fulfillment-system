package com.ezzerof.ordermanagementmicroservice.persistance.repository;

import com.ezzerof.ordermanagementmicroservice.persistance.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
