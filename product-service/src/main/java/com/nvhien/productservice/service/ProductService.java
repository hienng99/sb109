package com.nvhien.productservice.service;

import com.nvhien.productservice.dto.ProductRequest;
import com.nvhien.productservice.dto.ProductResponse;
import com.nvhien.productservice.model.Product;
import com.nvhien.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductResponse> getAllProducts() {
        log.warn("Get all products successfully.");
        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductResponse.class)).toList();
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.warn("Product {} is saved successfully.", product.getId());
    }
}
