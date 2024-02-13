package com.ezzerof.ordermanagementmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String customerName;
    private LocalDateTime orderedDateTime;
    private LocalDateTime deliveryDateTime;
    private String orderStatus;
    private String deliveryAddress;
    @OneToMany
    @JoinColumn(name = "orderId")
    private List<Item> list;
}
