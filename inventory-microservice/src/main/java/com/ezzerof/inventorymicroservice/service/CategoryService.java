package com.ezzerof.inventorymicroservice.service;

import com.ezzerof.inventorymicroservice.persistance.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryByName(String categoryName);
    Category addCategory(Category category);
    Category updateCategory(String existingCategory, Category updatedCategory);
    void deleteCategory(String categoryName);
}
