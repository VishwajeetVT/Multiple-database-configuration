package com.data.multi.db.product.controller;

import com.data.multi.db.product.dto.ProductResponse;
import com.data.multi.db.product.model.Product;
import com.data.multi.db.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<Product> products = productRepository.findAll();

        List<ProductResponse> productResponseList = products.stream()
                .map(product -> new ProductResponse(product.getProductName(), product.getPrice()))
                .toList();

        return ResponseEntity.ok(productResponseList);
    }
}
