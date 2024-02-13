package com.ezzerof.inventorymicroservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
