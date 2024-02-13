package com.ezzerof.inventorymicroservice.service;

import com.ezzerof.inventorymicroservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productName);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProduct(Long productId);
    List<Product> getAllProducts();
}
