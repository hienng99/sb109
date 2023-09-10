package com.nvhien.productservice.controller;

import com.nvhien.productservice.dto.ProductRequest;
import com.nvhien.productservice.dto.ProductResponse;
import com.nvhien.productservice.model.Product;
import com.nvhien.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (var product : products) {
            productResponses.add(modelMapper.map(product, ProductResponse.class));
        }
        return productResponses;
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        productService.createProduct(product);
    }
}
