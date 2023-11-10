package com.kyy.java.chapter03.service;

import com.kyy.java.chapter03.model.Product;
import com.kyy.java.chapter03.exception.ProductSaveException;

public interface ProductService {
    void registerProduct(Product product) throws ProductSaveException;

    void removeProduct(long id);

}
