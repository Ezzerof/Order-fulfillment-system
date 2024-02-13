package com.ezzerof.inventorymicroservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int quantityInStock;
    private String description;
    private BigDecimal price;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "categoryName", referencedColumnName = "name")
    private Category category;
}
