package com.ezzerof.ordermanagementmicroservice.controller;

import com.ezzerof.ordermanagementmicroservice.exception.InvalidOrderException;
import com.ezzerof.ordermanagementmicroservice.model.Order;
import com.ezzerof.ordermanagementmicroservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = service.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        try {
            Order order = service.getOrderById(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        catch (InvalidOrderException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        try {
            Order addedOrder = service.addOrder(order);
            return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
        }
        catch (InvalidOrderException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long orderId) {
        try {
            Order updatedOrder = service.updateOrder(orderId, order);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        }
        catch (InvalidOrderException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        try {
            service.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (InvalidOrderException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
