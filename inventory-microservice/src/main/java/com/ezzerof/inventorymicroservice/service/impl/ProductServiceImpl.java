package com.ezzerof.inventorymicroservice.service.impl;

import com.ezzerof.inventorymicroservice.exception.ProductNotFoundException;
import com.ezzerof.inventorymicroservice.persistance.entity.Product;
import com.ezzerof.inventorymicroservice.persistance.repository.ProductRepository;
import com.ezzerof.inventorymicroservice.service.ProductService;
import com.ezzerof.inventorymicroservice.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    @Override
    public Product getProductById(Long productId) {
        return repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        ValidationUtils.validateProduct(updatedProduct);
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            updatedProduct.setId(productId);
            return repository.save(updatedProduct);
        } else {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent())
            repository.deleteById(productId);
        else
            throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
