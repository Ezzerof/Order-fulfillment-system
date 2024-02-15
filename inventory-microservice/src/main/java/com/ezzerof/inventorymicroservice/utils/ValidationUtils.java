package com.ezzerof.inventorymicroservice.utils;

import com.ezzerof.inventorymicroservice.exception.ValidationException;
import com.ezzerof.inventorymicroservice.persistance.entity.Category;
import com.ezzerof.inventorymicroservice.persistance.entity.Product;

public class ValidationUtils {
    public static void validateCategory(Category category) {
        if (category == null ||
            category.getCategoryName() == null ||
            category.getProducts().isEmpty()
        )
            throw new ValidationException("Category cannot be null or have null states");
    }

    public static void validateProduct(Product product) {
        if (product == null ||
            product.getName() == null ||
            product.getPrice() == null ||
            product.getWeight() < 0 ||
            product.getDescription() == null ||
            product.getQuantityInStock() < 0 ||
            product.getCategory() == null
        )
            throw new ValidationException("Product cannot be null or have null states");
    }
}
