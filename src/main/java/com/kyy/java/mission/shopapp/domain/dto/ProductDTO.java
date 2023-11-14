package com.kyy.java.mission.shopapp.domain.dto;

public class ProductDTO {
    long id;
    String name;
    String description;
    int price;
    int stockQuantity;

    private ProductDTO() {}

    public static ProductDTO of(long id, String name, String description, int price, int stockQuantity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = id;
        productDTO.name = name;
        productDTO.description = description;
        productDTO.price = price;
        productDTO.stockQuantity = stockQuantity;
        return productDTO;
    }

    public static ProductDTO emptyProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = 0;
        productDTO.name = "";
        productDTO.description = "";
        productDTO.price = 0;
        productDTO.stockQuantity = 0;
        return productDTO;
    }

    public void applyDiscount(double percentage) {
        this.price = (int) (this.price * (1 - percentage));
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
