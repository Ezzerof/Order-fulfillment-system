package com.ezzerof.inventorymicroservice.persistance.repository;

import com.ezzerof.inventorymicroservice.persistance.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
