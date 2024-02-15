package com.ezzerof.ordermanagementmicroservice.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private Double price;
}
