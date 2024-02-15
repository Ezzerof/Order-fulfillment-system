package com.ezzerof.inventorymicroservice.persistance.repository;

import com.ezzerof.inventorymicroservice.persistance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
