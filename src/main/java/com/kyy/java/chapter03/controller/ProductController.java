package com.kyy.java.chapter03.controller;

import com.kyy.java.chapter03.exception.ProductNameEmptyException;
import com.kyy.java.chapter03.exception.ProductSaveException;
import com.kyy.java.chapter03.model.Product;
import com.kyy.java.chapter03.service.ProductService;

public class ProductController {

    private ProductService productService;

    public String registerProduct(Product product) {
        if (!product.getName().equals("")) {
            throw new ProductNameEmptyException("Product name is empty");
        }
        try {
            productService.registerProduct(product);
            return "redirect:/product/list";
        } catch (ProductSaveException e) {
            e.printStackTrace();
        } finally {
            return "";
        }
    }


}
