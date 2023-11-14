package com.kyy.java.mission.shopapp.infra.repo.impl;

import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

import java.util.List;

public class ProductRepoImpl implements MemRepo<ProductDTO> {

    List<ProductDTO> products;

    public ProductRepoImpl(List<ProductDTO> list) {
        products = list;
    }

    @Override
    public void create(ProductDTO productDTO) {
        products.add(productDTO);
    }

    @Override
    public void update(long id, ProductDTO productDTO) {
        products.stream().filter(product -> product.getId() == id).findFirst().ifPresent(product -> {
            ProductDTO.of(product.getId(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getStockQuantity());
        });
    }

    @Override
    public void delete(long id) {
        products.remove((int) id);
    }

    @Override
    public ProductDTO findById(long id) {
        return products.stream().filter(productDTO -> productDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<ProductDTO> findAll() {
        return products;
    }
}
