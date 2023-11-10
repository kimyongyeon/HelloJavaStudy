package com.kyy.java.chapter03.service.impl;

import com.kyy.java.chapter03.exception.ProductSaveException;
import com.kyy.java.chapter03.model.Product;
import com.kyy.java.chapter03.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    private final ProductService productService;

    public ProductServiceImplTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void registerProduct() throws ProductSaveException {
        productService.registerProduct(new Product());

    }

}