package com.ezzerof.inventorymicroservice.rest.controller;

import com.ezzerof.inventorymicroservice.persistance.entity.Product;
import com.ezzerof.inventorymicroservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public RequestEntity<Product> getProductById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public RequestEntity<List<Product>> getAllProducts() {
        return null;
    }

    @PostMapping
    public RequestEntity<Product> addProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{productId}")
    public RequestEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{productId}")
    public RequestEntity<Void> deleteProduct(@PathVariable Long productId) {
        return null;
    }
}
