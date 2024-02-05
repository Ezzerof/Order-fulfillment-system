package com.ezzerof.ordermanagementmicroservice.service.impl;

import com.ezzerof.ordermanagementmicroservice.exception.InvalidOrderException;
import com.ezzerof.ordermanagementmicroservice.model.Order;
import com.ezzerof.ordermanagementmicroservice.repository.OrderRepository;
import com.ezzerof.ordermanagementmicroservice.service.OrderService;
import com.ezzerof.ordermanagementmicroservice.utils.ValidateObj;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return repository.findById(orderId)
                .orElseThrow(() -> new InvalidOrderException("Order does not exist"));
    }

    @Override
    public Order addOrder(Order order) {
        ValidateObj.validateOrder(order);
        return repository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> existentOrder = repository.findById(orderId);
        if (existentOrder.isPresent() && updatedOrder != null) {
            updatedOrder.setOrderId(orderId);
            return repository.save(updatedOrder);
        }
        else
            throw new InvalidOrderException("Order not found or invalid data");
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (repository.existsById(orderId))
            repository.deleteById(orderId);
        else
            throw new InvalidOrderException("Order does not exist");
    }
}
