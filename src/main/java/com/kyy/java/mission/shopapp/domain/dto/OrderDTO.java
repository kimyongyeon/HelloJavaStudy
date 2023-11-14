package com.kyy.java.mission.shopapp.domain.dto;

import java.time.LocalDateTime;

public class OrderDTO {
    long id;
    OrderStatus status;
    int totalAmount;
    CustomerDTO customer;

    ProductDTO productDTO;

    LocalDateTime orderDate;

    private OrderDTO() {}

    public static OrderDTO of(long id, OrderStatus status, ProductDTO productDTO, int totalAmount, CustomerDTO customer, LocalDateTime orderDate) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.id = id;
        orderDTO.status = status;
        orderDTO.totalAmount = totalAmount;
        orderDTO.customer = customer;
        orderDTO.orderDate = orderDate;
        orderDTO.productDTO = productDTO;
        return orderDTO;
    }

    int calculateTotalAmount() {
        return this.totalAmount;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
