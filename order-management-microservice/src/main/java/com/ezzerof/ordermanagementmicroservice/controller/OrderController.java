package com.ezzerof.ordermanagementmicroservice.controller;

import com.ezzerof.ordermanagementmicroservice.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping
    public List<Order> getAllOrders() {
        return null;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return null;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return null;
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@RequestBody Order order, @PathVariable Long orderId) {
        return null;
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {

    }
}
