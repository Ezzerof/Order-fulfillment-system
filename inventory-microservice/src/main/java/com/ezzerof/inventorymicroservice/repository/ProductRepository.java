package com.ezzerof.inventorymicroservice.repository;

import com.ezzerof.inventorymicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
