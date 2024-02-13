package com.ezzerof.inventorymicroservice.service.impl;

import com.ezzerof.inventorymicroservice.exception.ProductNotFoundException;
import com.ezzerof.inventorymicroservice.model.Product;
import com.ezzerof.inventorymicroservice.repository.ProductRepository;
import com.ezzerof.inventorymicroservice.service.ProductService;
import com.ezzerof.inventorymicroservice.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    @Override
    public Product getProductById(Long productName) {
        return repository.findById(productName).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        ValidationUtils.validateProduct(updatedProduct);
        Product product = getProductById(productId);
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        repository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
