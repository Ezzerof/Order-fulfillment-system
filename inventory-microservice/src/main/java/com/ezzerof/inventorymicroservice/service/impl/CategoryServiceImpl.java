package com.ezzerof.inventorymicroservice.service.impl;

import com.ezzerof.inventorymicroservice.exception.CategoryNotFoundException;
import com.ezzerof.inventorymicroservice.persistance.entity.Category;
import com.ezzerof.inventorymicroservice.persistance.repository.CategoryRepository;
import com.ezzerof.inventorymicroservice.service.CategoryService;
import com.ezzerof.inventorymicroservice.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Category> category = repository.findById(existingCategory);
        if (category.isPresent())
            return repository.save(updatedCategory);
        else
            throw new CategoryNotFoundException("Category not found");
    }

    @Override
    public void deleteCategory(String categoryName) {
        Optional<Category> category = repository.findById(categoryName);
        if (category.isPresent())
            repository.deleteById(categoryName);
        else
            throw new CategoryNotFoundException("Category not found");
    }
}
