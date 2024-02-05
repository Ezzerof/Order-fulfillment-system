package com.ezzerof.ordermanagementmicroservice.repository;

import com.ezzerof.ordermanagementmicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
