package com.kyy.java.chapter03.service.impl;

import com.kyy.java.chapter03.model.Product;
import com.kyy.java.chapter03.exception.ProductSaveException;
import com.kyy.java.chapter03.repository.PersistenceRepository;
import com.kyy.java.chapter03.service.ProductService;

public class ProductServiceImpl implements ProductService {

    private PersistenceRepository persistenceRepository;

    public ProductServiceImpl(PersistenceRepository persistenceRepository) {
        this.persistenceRepository = persistenceRepository;
    }

    @Override
    public void registerProduct(Product product) throws ProductSaveException {
        try {
            this.persistenceRepository.save(product);
        } catch (Exception e) {
            throw new ProductSaveException("Product save failed");
        }

    }

    @Override
    public void removeProduct(long id) {
        try {
            this.persistenceRepository.delete(id);
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
