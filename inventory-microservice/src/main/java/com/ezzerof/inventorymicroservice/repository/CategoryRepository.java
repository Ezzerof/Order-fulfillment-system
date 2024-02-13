package com.ezzerof.inventorymicroservice.repository;

import com.ezzerof.inventorymicroservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
