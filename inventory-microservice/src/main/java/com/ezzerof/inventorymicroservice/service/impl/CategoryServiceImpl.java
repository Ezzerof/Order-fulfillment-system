package com.ezzerof.inventorymicroservice.service.impl;

import com.ezzerof.inventorymicroservice.exception.CategoryNotFoundException;
import com.ezzerof.inventorymicroservice.model.Category;
import com.ezzerof.inventorymicroservice.repository.CategoryRepository;
import com.ezzerof.inventorymicroservice.service.CategoryService;
import com.ezzerof.inventorymicroservice.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return repository.findById(categoryName).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public Category addCategory(Category category) {
        ValidationUtils.validateCategory(category);
        return repository.save(category);
    }

    @Override
    public Category updateCategory(String existingCategory, Category updatedCategory) {
        ValidationUtils.validateCategory(updatedCategory);
        Category category = getCategoryByName(existingCategory);
        return repository.save(updatedCategory);
    }

    @Override
    public void deleteCategory(String categoryName) {
        Category category = repository.findById(categoryName).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        repository.deleteById(categoryName);
    }
}
