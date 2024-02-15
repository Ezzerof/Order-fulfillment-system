package com.ezzerof.inventorymicroservice.rest.controller;

import com.ezzerof.inventorymicroservice.persistance.entity.Category;
import com.ezzerof.inventorymicroservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService service;

    @GetMapping("/{categoryName}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String categoryName) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return null;
    }

    @PutMapping("{/categoryName}")
    public ResponseEntity<Category> updateCategory(@PathVariable String categoryName, @RequestBody Category category) {
        return null;
    }

    @DeleteMapping("{/categoryName}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryName) {
        return null;
    }
}
