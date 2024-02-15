package com.ezzerof.inventorymicroservice.service;

import com.ezzerof.inventorymicroservice.persistance.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long productId);
    List<Product> getAllProducts();
}
