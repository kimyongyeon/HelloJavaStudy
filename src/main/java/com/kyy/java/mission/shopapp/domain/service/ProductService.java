package com.kyy.java.mission.shopapp.domain.service;

import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

public class ProductService {

    private final MemRepo<ProductDTO> productRepo;

    public ProductService(MemRepo<ProductDTO> productRepo) {
        this.productRepo = productRepo;
    }

    public void registerProduct(ProductDTO product) {
        productRepo.create(product);
    }

    public void removeProduct(long id) {
        productRepo.delete(id);
    }

    public ProductDTO getProduct(long id) {
        return productRepo.findById(id);
    }



    public void updateStock(long id, int quantity) {
        ProductDTO productRepoById = productRepo.findById(id);

        if (productRepoById.getStockQuantity() < quantity) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        int remainStock = productRepoById.getStockQuantity() - quantity;

        ProductDTO productDTO = ProductDTO.of(productRepoById.getId(), productRepoById.getName(), productRepoById.getDescription(), productRepoById.getPrice(), remainStock);

        productRepo.update(id, productDTO);

    }

}
