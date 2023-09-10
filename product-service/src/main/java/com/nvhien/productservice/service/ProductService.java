package com.nvhien.productservice.service;

import com.nvhien.productservice.model.Product;
import com.nvhien.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        log.info("Get all products successfully.");
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        productRepository.save(product);
        log.info("Product {} is saved successfully.", product.getId());
    }
}
