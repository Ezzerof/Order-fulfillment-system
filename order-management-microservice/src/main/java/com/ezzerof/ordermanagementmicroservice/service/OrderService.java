package com.ezzerof.ordermanagementmicroservice.service;

import com.ezzerof.ordermanagementmicroservice.persistance.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order addOrder(Order order);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long orderId);
}
